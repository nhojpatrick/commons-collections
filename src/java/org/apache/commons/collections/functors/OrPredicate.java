/*
 *  Copyright 2001-2004 The Apache Software Foundation
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.apache.commons.collections.functors;

import java.io.Serializable;

import org.apache.commons.collections.Predicate;

/**
 * Predicate implementation that returns true if either of the predicates return true.
 * 
 * @since Commons Collections 3.0
 * @version $Revision: 1.5 $ $Date: 2004/05/16 11:16:01 $
 *
 * @author Stephen Colebourne
 */
public final class OrPredicate implements Predicate, Serializable {

    /** Serial version UID */
    static final long serialVersionUID = -8791518325735182855L;
    
    /** The array of predicates to call */
    private final Predicate iPredicate1;
    /** The array of predicates to call */
    private final Predicate iPredicate2;
    
    /**
     * Factory to create the predicate.
     * 
     * @param predicate1  the first predicate to check, not null
     * @param predicate2  the second predicate to check, not null
     * @return the <code>and</code> predicate
     * @throws IllegalArgumentException if either predicate is null
     */
    public static Predicate getInstance(Predicate predicate1, Predicate predicate2) {
        if (predicate1 == null || predicate2 == null) {
            throw new IllegalArgumentException("Predicate must not be null");
        }
        return new OrPredicate(predicate1, predicate2);
    }

    /**
     * Constructor that performs no validation.
     * Use <code>getInstance</code> if you want that.
     * 
     * @param predicate1  the first predicate to check, not null
     * @param predicate2  the second predicate to check, not null
     */
    public OrPredicate(Predicate predicate1, Predicate predicate2) {
        super();
        iPredicate1 = predicate1;
        iPredicate2 = predicate2;
    }

    /**
     * Evaluates the predicate returning true if either predicate returns true.
     * 
     * @param object  the input object
     * @return true if either decorated predicate returns true
     */
    public boolean evaluate(Object object) {
       return (iPredicate1.evaluate(object) || iPredicate2.evaluate(object));
    }

    /**
     * Gets the first predicate.
     * 
     * @return the predicate
     * @since Commons Collections 3.1
     */
    public Predicate getPredicate1() {
        return iPredicate1;
    }

    /**
     * Gets the second predicate.
     * @return the predicate
     * @since Commons Collections 3.1
     */
    public Predicate getPredicate2() {
        return iPredicate2;
    }

}
