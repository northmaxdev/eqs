/*
 * MIT License
 *
 * Copyright (c) 2024 Maxim Altoukhov
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package io.github.northmaxdev.eqs.domain;

import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public final class EarthquakeDataService {

    private static final String BASE_URL = "https://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/";

    // These enums mirror the feeds' parameterization
    // https://earthquake.usgs.gov/earthquakes/feed/v1.0/geojson.php

    public enum TimeInterval {
        PAST_HOUR,
        PAST_DAY,
        PAST_WEEK,
        PAST_MONTH
    }

    public enum MagnitudeFilter {
        AT_LEAST_1_0,
        AT_LEAST_2_5,
        AT_LEAST_4_5,
        SIGNIFICANT
    }

    private final RestClient restClient;

    public EarthquakeDataService() {
        this.restClient = RestClient.create(BASE_URL);
    }

    public EarthquakeDataset getData(TimeInterval timeInterval) {
        return getData(timeInterval, null);
    }

    // No magnitude filter == all earthquakes within the given time interval
    public EarthquakeDataset getData(TimeInterval timeInterval, @Nullable MagnitudeFilter magnitudeFilter) {
        // https://www.baeldung.com/spring-boot-restclient
        // https://geojson.org/
        // https://github.com/opendatalab-de/geojson-jackson
    }
}
