/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.struts2.util;

import com.opensymphony.xwork2.util.ValueStack;
import org.apache.struts2.views.util.ContextUtil;

/**
 * Various static methods used with components
 */
public class ComponentUtils {

    /**
     * If altSyntax (%{...}) is applied, simply strip the "%{" and "}" off.
     *
     * @param stack the ValueStack where the context value is searched for.
     * @param expr  the expression (must be not null)
     * @return the stripped expression if altSyntax is enabled. Otherwise
     *         the parameter expression is returned as is.
     */
    public static String stripExpressionIfAltSyntax(ValueStack stack, String expr) {
        if (altSyntax(stack)) {
            // does the expression start with %{ and end with }? if so, just cut it off!
            if (isExpression(expr)) {
                return expr.substring(2, expr.length() - 1);
            }
        }
        return expr;
    }

    /**
     * Is the altSyntax enabled? [TRUE]
     *
     * @param stack the ValueStack where the context value is searched for.
     * @return true if altSyntax is activated. False otherwise.
     *         See <code>struts.properties</code> where the altSyntax flag is defined.
     */
    public static boolean altSyntax(ValueStack stack) {
        return ContextUtil.isUseAltSyntax(stack.getContext());
    }

    /**
     * Check if object is expression base on altSyntax
     *
     * @param expr to treat as an expression
     * @return true if it is an expression
     */
    public static boolean isExpression(String expr) {
        return expr != null && expr.startsWith("%{") && expr.endsWith("}");
    }

    public static boolean containsExpression(String expr) {
        return expr != null && expr.contains("%{") && expr.contains("}");
    }

}
