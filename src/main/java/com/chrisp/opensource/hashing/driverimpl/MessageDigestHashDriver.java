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

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.chrisp.opensource.hashing.driver.HashDriverIf;


public class MessageDigestHashDriver implements HashDriverIf {
	private static final String DEFAULT_HASH_ALGORITHM = "MD5";
	private String hashType;
	MessageDigest messageDigest;

	public MessageDigestHashDriver() throws NoSuchAlgorithmException {
		messageDigest = MessageDigest.getInstance(MessageDigestHashDriver.DEFAULT_HASH_ALGORITHM);
		messageDigest.reset();
		hashType = MessageDigestHashDriver.DEFAULT_HASH_ALGORITHM;
	}

	public MessageDigestHashDriver(String ahashType) throws NoSuchAlgorithmException {
		this.hashType = ahashType;
		messageDigest = MessageDigest.getInstance(hashType);
		messageDigest.reset();
	}

	@Override
	public byte[] hash(String aString){
		messageDigest.update(aString.getBytes());
		return messageDigest.digest();
	}


	@Override
	protected Object clone() throws CloneNotSupportedException {

		MessageDigestHashDriver messageDigestHashDriver = (MessageDigestHashDriver) super.clone();
		try{
			messageDigestHashDriver.messageDigest = newDigest(hashType);
		}catch (NoSuchAlgorithmException nsae){
			throw new CloneNotSupportedException(nsae.getMessage());
		}

		return messageDigestHashDriver;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return hashType;
	}

	protected MessageDigest newDigest(String hashType) throws NoSuchAlgorithmException{
		messageDigest = MessageDigest.getInstance(hashType);
		messageDigest.reset();

		return messageDigest;
	}
}

