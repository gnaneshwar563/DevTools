package com.nt.main;

import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

@Suite
@SuiteDisplayName("Arithmetic Operations Test Suite")
@SelectPackages("com.nt.test") // picks all tests in package
//@SelectClasses({ ArithmeticOperationsTest1.class, ArtemeticOperationsTest2.class, ArtemeticOperationsTest3.class })
public class AllTests {
    // empty
}
