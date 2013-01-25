/*
 * Copyright (c) 2008 - 2012 10gen, Inc. <http://10gen.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.code.morphia.mapping.validation;

/**
 *
 */

import com.google.code.morphia.mapping.MappingException;

import java.util.Collection;

/**
 * @author Uwe Schaefer, (us@thomas-daily.de)
 */
public class ConstraintViolationException extends MappingException {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public ConstraintViolationException(final Collection<ConstraintViolation> ve) {
        super(createString(ve.toArray(new ConstraintViolation[ve.size()])));
    }

    public ConstraintViolationException(final ConstraintViolation... ve) {
        super(createString(ve));
    }

    private static String createString(final ConstraintViolation[] ve) {
        final StringBuffer sb = new StringBuffer(128);
        sb.append("Number of violations: " + ve.length + "\n");
        for (final ConstraintViolation validationError : ve) {
            sb.append(validationError.render());
        }
        final String message = sb.toString();
        return message;
    }
}