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
package com.inscription;

import java.util.ArrayList;

public class Credits extends ArrayList<Object> {
    public static class Section extends ArrayList<Object> {
        String title = "";

        /**
         * Set Section's display title.
         *
         * @param title new value
         */
        public void setTitle(String title) {
            this.title = title;
        }

        /**
         * Gets the Section's display title.
         *
         * @return display title set for this object.
         */
        public String getTitle() {
            return this.title;
        }
    }

    public static class Role extends ArrayList<Credit> {
        String title = "";


        /**
         * Set Role's display title.
         *
         * @param title new value
         */
        public void setTitle(String title) {
            this.title = title;
        }

        /**
         * Gets the Role's display title.
         *
         * @return display title set for this object.
         */
        public String getTitle() {
            return this.title;
        }
    }

    public static class Credit extends ArrayList<URL> {
        String text = "";

        /**
         * Set Credit's display text.
         *
         * @param text new value
         */
        public void setText(String text) {
            this.text = text;
        }

        /**
         * Gets the Credits's display title.
         *
         * @return display title set for this object.
         */
        public String getText() {
            return this.text;
        }
    }

    public class Text {
        String text = "";

        /**
         * Set Text's display text.
         *
         * @param text new value
         */
        public void setText(String text) {
            this.text = text;
        }

        /**
         * Gets the Text's display text.
         *
         * @return display text set for this object.
         */
        public String getText() {
            return this.text;
        }
    }

    public static class Copyright extends ArrayList<URL> {
        String text = "";

        /**
         * Set Copyright's display text.
         *
         * @param text new value
         */
        public void setText(String text) {
            this.text = text;
        }

        /**
         * Gets the Copyright's display text.
         *
         * @return display text set for this object.
         */
        public String getText() {
            return this.text;
        }
    }

    public static class URL {
        String title = "";
        String URL = "";

        /**
         * Set URL's display title.
         *
         * @param title new value
         */
        public void setTitle(String title) {
            this.title = title;
        }

        /**
         * Gets the URL's display title.
         *
         * @return display title set for this object.
         */
        public String getTitle() {
            return this.title;
        }

        /**
         * Set the URL's web URL.
         *
         * @param URL new value
         */
        public void setURL(String URL) {
            this.URL = URL;
        }

        /**
         * Gets the URL's web URL.
         *
         * @return URL set for this object.
         */
        public String getURL() {
            return this.URL;
        }
    }

    public static class Websites extends ArrayList<URL> {

    }
}
