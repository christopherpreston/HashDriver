/*
MIT License

Copyright (c) 2017 Christopher Preston

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
*/


/**
 * Author: chrisp December 2009
 */

package com.chrisp.opensource.hashing.driverimpl;

import com.chrisp.opensource.hashing.driver.HashDriverIf;
import com.chrisp.opensource.hashing.opensource.GeneralHashFunctionLibrary;


public class SimpleStringHashDriver implements HashDriverIf {
	private static final String SIMPLE_STRING = "SIMPLE_STRING";
	GeneralHashFunctionLibrary library = new GeneralHashFunctionLibrary();

	@Override
	public byte[] hash(String aString){
		int len = aString.length();

		if (len == 0) {
			return Long.toString(0).getBytes();
		}

		if (len == 1) {
			return Long.toString(aString.hashCode()).getBytes();
		}

		int halfLen = len / 2;
		return Long
		.toHexString(
				((long) aString.substring(halfLen, len).hashCode()) << 32 + aString
				.subSequence(0, halfLen).hashCode()).getBytes();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#clone()
	 */
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return SimpleStringHashDriver.SIMPLE_STRING;
	}
}


