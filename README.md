# HashDriver
Driver layer for running various hashing algorithms 

This is a driver layer for various hashing algorithms written back in 2009 in Java. I wanted to benchmark various hashing algorithms. Different algorithms required different calls so I combined them through a single driver interface to avoid having more complex code. Benchmarks and collision rates are shown by running the unit test which is fairly simplistic. I did this originally in Netbeans and decided to open source it under the MIT license with gradle for the build. It should download and build a jar without modification if you have gradle installed. If you do not have gradle installed the gradle wrapper is included.

An example output of the unit test looks like the following on my slow (but lightweight :) ) notebook:

Testing hash type: RS </br>
RS hashes/sec = 1242750 </br>
RScollision ratio = 0% - collision count = 0 map size = 3000000 </br>
Testing hash type: SIMPLE_STRING </br>
SIMPLE_STRING hashes/sec = 1063452 </br>
SIMPLE_STRINGcollision ratio = 26% - collision count = 807103 map size = 2192897 </br>
Testing hash type: BKDR </br>
BKDR hashes/sec = 2073255 </br>
BKDRcollision ratio = 0% - collision count = 0 map size = 3000000 </br>
Testing hash type: JS </br>
JS hashes/sec = 3409090 </br>
JScollision ratio = 1% - collision count = 30293 map size = 2969707 </br>
Testing hash type: DEK </br>
DEK hashes/sec = 5050505 </br>
DEKcollision ratio = 1% - collision count = 30900 map size = 2969100 </br>
Testing hash type: SHA </br>
SHA hashes/sec = 2035278 </br>
SHAcollision ratio = 0% - collision count = 0 map size = 3000000 </br>
Testing hash type: BP </br>
BP hashes/sec = 5736137 </br>
BPcollision ratio = 0% - collision count = 0 map size = 3000000 </br>
Testing hash type: AP </br>
AP hashes/sec = 3529411 </br>
APcollision ratio = 0% - collision count = 3 map size = 2999997 </br>
Testing hash type: FNV </br>
FNV hashes/sec = 3271537 </br>
FNVcollision ratio = 0% - collision count = 0 map size = 3000000 </br>
Testing hash type: SDBM </br>
SDBM hashes/sec = 4132231 </br>
SDBMcollision ratio = 0% - collision count = 0 map size = 3000000 </br>
Testing hash type: PJW </br>
PJW hashes/sec = 5725190 </br>
PJWcollision ratio = 2% - collision count = 82921 map size = 2917079 </br>
Testing hash type: DJB </br>
DJB hashes/sec = 4636785 </br>
DJBcollision ratio = 0% - collision count = 28068 map size = 2971932 </br>
Testing hash type: ELF </br>
ELF hashes/sec = 5607476 </br>
ELFcollision ratio = 2% - collision count = 82921 map size = 2917079 </br>
Testing hash type: MD5 </br>
MD5 hashes/sec = 2518891 </br>
MD5collision ratio = 0% - collision count = 0 map size = 3000000 </br>

