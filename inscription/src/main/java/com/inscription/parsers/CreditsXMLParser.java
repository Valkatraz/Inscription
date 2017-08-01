/*
 * (c) 2017 Martin van Zuilekom (https://github.com/MartinvanZ/Inscription)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package com.inscription.parsers;

import android.content.Context;
import android.content.res.XmlResourceParser;
import android.util.Log;

import com.inscription.Credits;
import com.inscription.Credits.Copyright;
import com.inscription.Credits.Credit;
import com.inscription.Credits.Role;
import com.inscription.Credits.Section;
import com.inscription.Credits.URL;
import com.inscription.Credits.Websites;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;

public class CreditsXMLParser {

    private static String TAG = "CreditsXMLParser";

    /**
     * Parse a credits xml file.
     *
     * @param context  the parent context
     * @param resourceId resourceId of the credits xml file.
     *
     * @return a Credit object based on the parsed information. Returns null if a parse error occurred.
     */
    public static Credits parseXMLCreditsFile(Context context, final int resourceId) {
        Credits result = new Credits();
        final XmlResourceParser xml = context.getResources().getXml(resourceId);
        try
        {
            int eventType = xml.getEventType();
            while (eventType != XmlPullParser.END_DOCUMENT) {
                if ((eventType == XmlPullParser.START_TAG) && (xml.getName().equals("section"))){
                    result.add(parseSectionTag(xml));

                }
                if ((eventType == XmlPullParser.START_TAG) && (xml.getName().equals("copyright"))){
                    result.add(parseCopyrightTag(xml));

                }
                if ((eventType == XmlPullParser.START_TAG) && (xml.getName().equals("websites"))){
                    result.add(parseWebsitesTag(xml));

                }
                eventType = xml.next();
            }
        }
        catch (final XmlPullParserException | IOException e) {
            Log.e(TAG, e.getMessage(), e);
            return null;
        } finally {
            xml.close();
        }
        return result;
    }


    /**
     * Parse a credit tag
     * @param xml XmlResourceParser object to parse a credits tag
     *
     * @return a Credit object based on the parsed information.
     *
     * @throws XmlPullParserException
     * @throws IOException
     */
    private static Credit parseCreditTag(final XmlResourceParser xml) throws XmlPullParserException, IOException {
        Credit result = new Credit();
        int eventType = xml.getEventType();
        while (!((eventType == XmlPullParser.END_TAG) && (xml.getName().equals("credit")))) {
            if (eventType == XmlPullParser.TEXT){
                result.setText(xml.getText());
            }
            if ((eventType == XmlPullParser.START_TAG) && (xml.getName().equals("url"))){
                result.add(parseUrlTag(xml));
            }
            eventType = xml.next();
        }
        return result;
    }

    /**
     * Parse a role tag
     *
     * @param xml XmlResourceParser object to parse a role tag
     *
     * @return a Role object based on the parsed information.
     *
     * @throws XmlPullParserException
     * @throws IOException
     */
    private static Role parseRoleTag(final XmlResourceParser xml) throws XmlPullParserException, IOException {
        Role result = new Role();
        result.setTitle(xml.getAttributeValue(null, "title"));
        int eventType = xml.getEventType();
        while ((eventType != XmlPullParser.END_TAG) || (xml.getName().equals("credit"))) {
            if ((eventType == XmlPullParser.START_TAG) && (xml.getName().equals("credit"))){
                xml.next(); //ToDo: Do we need a next here?
                result.add(parseCreditTag(xml));
            }
            eventType = xml.next();
        }
        return result;
    }

    /**
     * Parse a section tag
     *
     * @param xml XmlResourceParser object to parse a section tag
     *
     * @return a Section object based on the parsed information.
     *
     * @throws XmlPullParserException
     * @throws IOException
     */
    private static Section parseSectionTag(final XmlResourceParser xml) throws XmlPullParserException, IOException {
        Section result = new Section();
        result.setTitle(xml.getAttributeValue(null, "title"));
        int eventType = xml.getEventType();
        while ((eventType != XmlPullParser.END_TAG) || (xml.getName().equals("role"))) {
            if ((eventType == XmlPullParser.START_TAG) && (xml.getName().equals("role"))){
                result.add(parseRoleTag(xml));
            }
            eventType = xml.next();
        }
        return result;
    }

    /**
     * Parse a url tag
     *
     * @param xml XmlResourceParser object to parse a url tag
     *
     * @return a URL object based on the parsed information.
     *
     * @throws XmlPullParserException
     * @throws IOException
     */
    private static URL parseUrlTag(final XmlResourceParser xml) throws XmlPullParserException, IOException {
        int eventType = xml.getEventType();
        URL result = new URL();
        String _Url = "";
        String _Title = "";
        if (xml.getAttributeValue(null, "title") != null)
            _Title = xml.getAttributeValue(null, "title");
        while (eventType != XmlPullParser.END_TAG) {
            if (eventType == XmlPullParser.TEXT){
                _Url = xml.getText();
            }
            eventType = xml.next();
        }
        if (_Url.equals(""))
            throw new RuntimeException("Could not parse credit file: URL tag is empty");
        result.setURL(_Url);
        if (_Title.equals(""))
            _Title = _Url;
        result.setTitle(_Title);
        return result;
    }

    /**
     * Parse a copyright tag
     *
     * @param xml XmlResourceParser object to parse a copyright tag
     *
     * @return a Copyright object based on the parsed information.
     *
     * @throws XmlPullParserException
     * @throws IOException
     */
    private static Copyright parseCopyrightTag(final XmlResourceParser xml) throws XmlPullParserException, IOException {
        Copyright result = new Copyright();
        int eventType = xml.getEventType();
        while (!((eventType == XmlPullParser.END_TAG) && (xml.getName().equals("copyright")))) {
            if (eventType == XmlPullParser.TEXT){
                result.setText(xml.getText());
            }
            if ((eventType == XmlPullParser.START_TAG) && (xml.getName().equals("url"))){
                result.add(parseUrlTag(xml));
            }
            eventType = xml.next();
        }
        return result;
    }

    /**
     * Parse a websites tag
     *
     * @param xml XmlResourceParser object to parse a websites tag
     *
     * @return a Websites object based on the parsed information.
     *
     * @throws XmlPullParserException
     * @throws IOException
     */
    private static Websites parseWebsitesTag(final XmlResourceParser xml) throws XmlPullParserException, IOException {
        Websites result = new Websites();
        int eventType = xml.getEventType();
        while (!((eventType == XmlPullParser.END_TAG) && (xml.getName().equals("websites")))) {
            if ((eventType == XmlPullParser.START_TAG) && (xml.getName().equals("url"))){
                result.add(parseUrlTag(xml));
            }
            eventType = xml.next();
        }
        return result;
    }
}