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

package com.chrisp.opensource.hashing.driver;

import java.security.NoSuchAlgorithmException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.chrisp.opensource.hashing.driverimpl.APHashDriver;
import com.chrisp.opensource.hashing.driverimpl.BKDRHashDriver;
import com.chrisp.opensource.hashing.driverimpl.BPHashDriver;
import com.chrisp.opensource.hashing.driverimpl.DEKHashDriver;
import com.chrisp.opensource.hashing.driverimpl.DJBHashDriver;
import com.chrisp.opensource.hashing.driverimpl.ELFHashDriver;
import com.chrisp.opensource.hashing.driverimpl.FNVHashDriver;
import com.chrisp.opensource.hashing.driverimpl.JSHashDriver;
import com.chrisp.opensource.hashing.driverimpl.MessageDigestHashDriver;
import com.chrisp.opensource.hashing.driverimpl.PJWHashDriver;
import com.chrisp.opensource.hashing.driverimpl.RSHashDriver;
import com.chrisp.opensource.hashing.driverimpl.SDBMHashDriver;
import com.chrisp.opensource.hashing.driverimpl.SimpleStringHashDriver;


public class SupportedHashDriverMap extends
java.util.AbstractMap<String, HashDriverIf> {
	public static final HashDriverIf[] generalHashFunctionLibraryDrivers =
	{
		new APHashDriver(),
		new BKDRHashDriver(),
		new BPHashDriver(),
		new DEKHashDriver(),
		new DJBHashDriver(),
		new ELFHashDriver(),
		new FNVHashDriver(),
		new JSHashDriver(),
		new PJWHashDriver(),
		new RSHashDriver(),
		new SDBMHashDriver(),
		new SimpleStringHashDriver()
	};

	public static final String messageDigestHashAlgorithms[] = { "MD5", "SHA" };

	private static final HashMap<String, HashDriverIf> hashDriverMap = new HashMap<String, HashDriverIf>();
	{
		for (HashDriverIf driver : SupportedHashDriverMap.generalHashFunctionLibraryDrivers) {
			SupportedHashDriverMap.hashDriverMap.put(driver.getName(), driver);
		}

		for (String hashType : SupportedHashDriverMap.messageDigestHashAlgorithms) {
			try {
				HashDriverIf driver = new MessageDigestHashDriver(hashType);
				SupportedHashDriverMap.hashDriverMap.put(hashType, driver);
			} catch (NoSuchAlgorithmException nsae) {
				throw new RuntimeException("Failed to load " + hashType
						+ " driver", nsae);
			}
		}
	}


	@Override
	public void clear() {
		SupportedHashDriverMap.hashDriverMap.clear();
	}


	@Override
	public boolean containsKey(Object pKey) {
		return SupportedHashDriverMap.hashDriverMap.containsKey(pKey);
	}


	@Override
	public boolean containsValue(Object pValue) {
		return SupportedHashDriverMap.hashDriverMap.containsValue(pValue);
	}


	@Override
	public boolean equals(Object pO) {
		return SupportedHashDriverMap.hashDriverMap.equals(pO);
	}


	@Override
	public HashDriverIf get(Object pKey) {
		return SupportedHashDriverMap.hashDriverMap.get(pKey);
	}


	@Override
	public boolean isEmpty() {
		return SupportedHashDriverMap.hashDriverMap.isEmpty();
	}


	@Override
	public Set<String> keySet() {
		return SupportedHashDriverMap.hashDriverMap.keySet();
	}


	@Override
	public HashDriverIf put(String pKey, HashDriverIf pValue) {
		return SupportedHashDriverMap.hashDriverMap.put(pKey, pValue);
	}


	@Override
	public void putAll(Map<? extends String, ? extends HashDriverIf> pM) {
		super.putAll(pM);
	}


	@Override
	public HashDriverIf remove(Object pKey) {
		return super.remove(pKey);
	}


	@Override
	public int size() {
		return SupportedHashDriverMap.hashDriverMap.size();
	}


	@Override
	public Collection<HashDriverIf> values() {
		return SupportedHashDriverMap.hashDriverMap.values();
	}

	@Override
	public Set<java.util.Map.Entry<String, HashDriverIf>> entrySet() {
		return SupportedHashDriverMap.hashDriverMap.entrySet();
	}
}


