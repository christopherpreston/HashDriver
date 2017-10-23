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

1) install gradle on your system and configure GRADLE_HOME as an environment variable
pointing to your gradle installation
2) go into the HashDriver directory you downloaded
3) type gradle build from a command line

If you're using Eclipse you should be able to:

1) create an Eclipse gradle project - this requires a gradle plugin. I use Buildship
2) copy the gradle files and build.gradle to your Eclipse project directory
3) copy the source directory to your new Eclipse project directory
4) right click on the project and select Gradle -> Refresh Gradle project.
This step synchronizes Eclipse's configuration including the build path with the
build.gradle file

Eclipse should automatically build the project. You can then right click on the unit
test SupportedHashDriverMapTest and select Run as -> junit test

