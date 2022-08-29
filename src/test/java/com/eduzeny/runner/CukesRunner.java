package com.eduzeny.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        //Burada butun yapilari birbirine bagliyoruz.

        plugin = {
                "pretty",
                "html:target/cucumber-reports.html",
                "rerun:target/rerun.txt",
                "me.jvt.cucumber.report.PrettyReports:target/cucumber",
                "json:target/cucumber.json"
        },

        features = "src/test/resources/features",//business layer
        glue = "com/eduzeny/step_definitions",//implementation layer
        //dryRun = true //implement edilmeyenleri de yakalar. Veya snippetlari almak icin kullaniriz.
        dryRun = false, //sadece class icindekileri alir
        //tags = "@wipOrder" //istedigimiz @Tagleri buraya koyuyoruz\
        //"@librarian or @student" durumunda her ikisini de ayri ayri calistirir.
        //tags = "@librarian and @student" Her iki tage sahip olanlari calistirir
        //tags = "@google_scenario_outline"
        //tags = "@wikipedia"
        //tags = "@wiptableorder"
        //tags = "@bear1"
        tags = "@google" //working in progress   //@regression, @smoke


)

public class CukesRunner {
}


