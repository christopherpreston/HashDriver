# HashDriver
Driver layer for running various hashing algorithms 

This is a driver layer for various hashing algorithms written back in 2009 in Java. I wanted to benchmark various hashing algorithms. Different algorithms required different calls so I combined them through a single driver interface to avoid having more complex code. Benchmarks and collision rates are shown by running the unit test which is fairly simplistic. I did this originally in Netbeans and decided to open source it under the MIT license with gradle for the build. It should download and build a jar without modification if you have gradle installed. If you do not have gradle installed the gradle wrapper is included.

An example output of the unit test looks like the following on my slow (but lightweight :) ) notebook:

Testing hash type: RS
RS hashes/sec = 1242750
RScollision ratio = 0% - collision count = 0 map size = 3000000
Testing hash type: SIMPLE_STRING
SIMPLE_STRING hashes/sec = 1063452
SIMPLE_STRINGcollision ratio = 26% - collision count = 807103 map size = 2192897
Testing hash type: BKDR
BKDR hashes/sec = 2073255
BKDRcollision ratio = 0% - collision count = 0 map size = 3000000
Testing hash type: JS
JS hashes/sec = 3409090
JScollision ratio = 1% - collision count = 30293 map size = 2969707
Testing hash type: DEK
DEK hashes/sec = 5050505
DEKcollision ratio = 1% - collision count = 30900 map size = 2969100
Testing hash type: SHA
SHA hashes/sec = 2035278
SHAcollision ratio = 0% - collision count = 0 map size = 3000000
Testing hash type: BP
BP hashes/sec = 5736137
BPcollision ratio = 0% - collision count = 0 map size = 3000000
Testing hash type: AP
AP hashes/sec = 3529411
APcollision ratio = 0% - collision count = 3 map size = 2999997
Testing hash type: FNV
FNV hashes/sec = 3271537
FNVcollision ratio = 0% - collision count = 0 map size = 3000000
Testing hash type: SDBM
SDBM hashes/sec = 4132231
SDBMcollision ratio = 0% - collision count = 0 map size = 3000000
Testing hash type: PJW
PJW hashes/sec = 5725190
PJWcollision ratio = 2% - collision count = 82921 map size = 2917079
Testing hash type: DJB
DJB hashes/sec = 4636785
DJBcollision ratio = 0% - collision count = 28068 map size = 2971932
Testing hash type: ELF
ELF hashes/sec = 5607476
ELFcollision ratio = 2% - collision count = 82921 map size = 2917079
Testing hash type: MD5
MD5 hashes/sec = 2518891
MD5collision ratio = 0% - collision count = 0 map size = 3000000

