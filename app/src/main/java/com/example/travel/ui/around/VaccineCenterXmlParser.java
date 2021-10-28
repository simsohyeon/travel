package com.example.travel.ui.around;

import android.location.Location;
import android.util.Xml;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class VaccineCenterXmlParser extends AroundXmlParser {

    private final double mLatitude;
    private final double mLongitude;
    private final double mRadius;


    public VaccineCenterXmlParser(double latitude, double longitude, double radius) {
        this.mLatitude = latitude;
        this.mLongitude = longitude;
        this.mRadius = radius;
    }

    // 주어진 XML 파싱하기
    @Override
    public List<Around> parse(InputStream in) throws XmlPullParserException, IOException {
        try {
            XmlPullParser parser = Xml.newPullParser();
            parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
            parser.setInput(in, null);
            parser.nextTag();
            return readResults(parser);
        } finally {
            in.close();
        }
    }

    // results 태그 읽기
    private List<Around> readResults(XmlPullParser parser) throws XmlPullParserException, IOException {

        parser.require(XmlPullParser.START_TAG, ns, "results");
        while (parser.next() != XmlPullParser.END_TAG) {
            if (parser.getEventType() != XmlPullParser.START_TAG) {
                continue;
            }
            String name = parser.getName();
            // data 태그 찾기
            if (name.equals("data")) {
                return readData(parser);
            } else {
                skip(parser);
            }
        }
        return null;
    }

    // data 태그 읽기
    private List<Around> readData(XmlPullParser parser) throws XmlPullParserException, IOException {

        List<Around> articleList = new ArrayList<>();

        parser.require(XmlPullParser.START_TAG, ns, "data");
        while (parser.next() != XmlPullParser.END_TAG) {
            if (parser.getEventType() != XmlPullParser.START_TAG) {
                continue;
            }
            String name = parser.getName();
            // item 태그 찾기
            if (name.equals("item")) {
                Around around = readItem(parser);
                if (around.getDistance() <= mRadius) {
                    articleList.add(around);
                }
            } else {
                skip(parser);
            }
        }
        return articleList;
    }

    // item 태그 읽기
    private Around readItem(XmlPullParser parser) throws XmlPullParserException, IOException {

        parser.require(XmlPullParser.START_TAG, ns, "item");
        String name = null;
        String address = null;
        double longitude = 0;
        double latitude = 0;

        while (parser.next() != XmlPullParser.END_TAG) {
            if (parser.getEventType() != XmlPullParser.START_TAG) {
                continue;
            }
            String tag = parser.getName();
            if (!tag.equals("col")) {
                skip(parser);
            }

            String attr = parser.getAttributeValue(ns, "name");
            switch (attr) {
                case "centerName":
                    name = readCenterName(parser);
                    break;
                case "address":
                    address = readAddress(parser);
                    break;
                case "lat":
                    longitude = readLongitude(parser);
                    break;
                case "lng":
                    latitude = readLatitude(parser);
                    break;
                default:
                    skip(parser);
                    break;
            }
        }

        float[] distance = new float[3];
        Location.distanceBetween(mLatitude, mLongitude, latitude, longitude, distance);
        return new Around(name, address, "", latitude, longitude, distance[0]);
    }

    // centerName 태그의 내용 읽기
    private String readCenterName(XmlPullParser parser) throws IOException, XmlPullParserException {

        parser.require(XmlPullParser.START_TAG, ns, "col");
        String address = readText(parser);
        parser.require(XmlPullParser.END_TAG, ns, "col");
        return address;
    }

    // address 태그의 내용 읽기
    private String readAddress(XmlPullParser parser) throws IOException, XmlPullParserException {

        parser.require(XmlPullParser.START_TAG, ns, "col");
        String address = readText(parser);
        parser.require(XmlPullParser.END_TAG, ns, "col");
        return address;
    }

    // lng 태그의 내용 읽기
    private double readLongitude(XmlPullParser parser) throws IOException, XmlPullParserException {

        parser.require(XmlPullParser.START_TAG, ns, "col");
        String strLongitude = readText(parser);
        parser.require(XmlPullParser.END_TAG, ns, "col");
        return Double.parseDouble(strLongitude);
    }

    // lat 태그의 내용 읽기
    private double readLatitude(XmlPullParser parser) throws IOException, XmlPullParserException {

        parser.require(XmlPullParser.START_TAG, ns, "col");
        String strLatitude = readText(parser);
        parser.require(XmlPullParser.END_TAG, ns, "col");
        return Double.parseDouble(strLatitude);
    }

}
