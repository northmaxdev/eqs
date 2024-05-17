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

import jakarta.annotation.Nonnull;

import java.time.Instant;
import java.util.Objects;

public record Earthquake(double magnitude, @Nonnull Location location, @Nonnull Instant occurrenceTimestamp) implements Comparable<Earthquake> {

    public Earthquake(double magnitude, @Nonnull Location location, @Nonnull Instant occurrenceTimestamp) {
        this.magnitude = magnitude;
        this.location = Objects.requireNonNull(location, "null earthquake location");
        this.occurrenceTimestamp = Objects.requireNonNull(occurrenceTimestamp, "null earthquake occurrence timestamp");
    }

    @Override
    public int compareTo(@Nonnull Earthquake other) {
        Objects.requireNonNull(other);
        return Double.compare(this.magnitude, other.magnitude);
    }
}
