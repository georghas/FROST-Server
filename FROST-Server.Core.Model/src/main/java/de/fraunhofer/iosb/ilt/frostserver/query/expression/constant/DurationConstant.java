/*
 * Copyright (C) 2024 Fraunhofer Institut IOSB, Fraunhoferstr. 1, D 76131
 * Karlsruhe, Germany.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package de.fraunhofer.iosb.ilt.frostserver.query.expression.constant;

import de.fraunhofer.iosb.ilt.frostserver.query.expression.ExpressionVisitor;
import de.fraunhofer.iosb.ilt.frostserver.util.StringHelper;
import java.text.ParseException;
import net.time4j.Duration;

/**
 *
 * @author jab
 */
public class DurationConstant extends Constant<Duration> {

    public DurationConstant(Duration value) {
        super(value);
    }

    public DurationConstant(String value) throws ParseException {
        super(Duration.parsePeriod(value));
    }

    @Override
    public String toUrl() {
        return "duration'" + getValue().toString() + "'";
    }

    public String asISO8601() {
        return getValue().toStringISO();
    }

    @Override
    public <O> O accept(ExpressionVisitor<O> visitor) {
        return visitor.visit(this);
    }

    public static DurationConstant parse(String value) {
        try {
            return new DurationConstant(value);
        } catch (ParseException ex) {
            throw new IllegalArgumentException("Failed to parse Duration " + StringHelper.cleanForLogging(value), ex);
        }
    }

}
