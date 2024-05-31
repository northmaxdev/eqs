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

package io.github.northmaxdev.eqs.earthquake;

import java.util.Collection;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;

public final class EarthquakeDataset {

    private final Collection<Earthquake> earthquakes;

    private EarthquakeDataset(Collection<Earthquake> earthquakes) {
        this.earthquakes = earthquakes;
    }

    public static EarthquakeDataset of(Collection<Earthquake> earthquakes) {
        Collection<Earthquake> protectiveCopy = List.copyOf(earthquakes); // Implicit null-check (including the Collection contents)
        return new EarthquakeDataset(protectiveCopy);
    }

    public Optional<Earthquake> getWeakest() {
        return earthquakes.stream()
                .min(Earthquake::compareTo);
    }

    public Optional<Earthquake> getStrongest() {
        return earthquakes.stream()
                .max(Earthquake::compareTo);
    }

    public OptionalDouble getAverageMagnitude() {
        return earthquakes.stream()
                .mapToDouble(Earthquake::magnitude)
                .average();
    }

    // We could, technically, implement a simple EarthquakeSummaryStatistics,
    // but DoubleSummaryStatistics does some funky floating-point arithmetic stuff (at least on Temurin Java 21),
    // and it's probably there for a reason (I trust the JDK developers to be smarter than me)

    public DoubleSummaryStatistics getMagnitudeStats() {
        return earthquakes.stream()
                .mapToDouble(Earthquake::magnitude)
                .summaryStatistics();
    }

    public int size() {
        return earthquakes.size();
    }
}
