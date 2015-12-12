package com.moomoo.calc.node;

/*
 * This file is part of org.jessies.calc.
 * Copyright (C) 2009 Elliott Hughes <enh@jessies.org>.
 * 
 * LittleHelper is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

/**
 * There are three kinds of number: integer (IntegerNode), rational (RationalNode), and machine-precision real (RealNode).
 */
public interface NumberNode extends Node {
    public NumberNode abs();
    public NumberNode divide(NumberNode rhs);
    public NumberNode fractionalPart();
    public NumberNode increment();
    public IntegerNode integerPart();
    public NumberNode plus(NumberNode rhs);
    public NumberNode power(NumberNode rhs);
    public IntegerNode sign();
    public NumberNode subtract(NumberNode rhs);
    public NumberNode times(NumberNode rhs);
    public RealNode toReal();
}
