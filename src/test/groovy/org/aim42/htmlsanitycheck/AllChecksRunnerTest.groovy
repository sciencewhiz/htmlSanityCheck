package org.aim42.htmlsanitycheck

import org.aim42.htmlsanitycheck.collect.SingleCheckResults
import org.aim42.htmlsanitycheck.collect.SinglePageResults
import org.junit.Before
import org.junit.Test

class AllChecksRunnerTest extends GroovyTestCase {

    final static String HTML_HEAD = '<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN"> <head></head><html>'

    private File tmpFile

    private AllChecksRunner allChecksRunner

    @Before
    void setup() {

    }

    // TODO: create a useful test here...



    @Test
    public void testSingleCorrectHTMLFile() {
        String HTML = """$HTML_HEAD<body><title>hsc</title></body></html>"""

        // create file with proper html content
        tmpFile = File.createTempFile("testfile", ".html")
        tmpFile.write( HTML )

        allChecksRunner = new AllChecksRunner( tmpFile )

        SinglePageResults pageResults = allChecksRunner.performAllChecksForOneFile(tmpFile)

        // expectation:
        // 4 checks run
        // 0 items checked
        // 0 findings
        // title = "hsc"
        int expected = 4
        assertEquals("expected $expected kinds of checks", expected, pageResults.singleCheckResults.size())

        assertEquals("expected 0 items checked", 0,  pageResults.totalNrOfItemsChecked())

        assertEquals("expected 0 findings", 0, pageResults.totalNrOfFindings())

        assertEquals("expected hsc title", "hsc", pageResults.pageTitle)
    }

}

/************************************************************************
 * This is free software - without ANY guarantee!
 *
 *
 * Copyright 2014, Dr. Gernot Starke, arc42.org
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
 *
 *********************************************************************** */



