package com.google.firebase.crashlytics.internal.send;

import X0.h;
import X0.j;
import a1.u;
import android.content.Context;
import com.google.android.gms.tasks.Task;
import com.google.firebase.crashlytics.internal.common.CrashlyticsReportWithSessionId;
import com.google.firebase.crashlytics.internal.common.OnDemandCounter;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import com.google.firebase.crashlytics.internal.model.serialization.CrashlyticsReportJsonTransform;
import com.google.firebase.crashlytics.internal.settings.SettingsProvider;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes.dex */
public class DataTransportCrashlyticsReportSender {
    private static final String CRASHLYTICS_TRANSPORT_NAME = "FIREBASE_CRASHLYTICS_REPORT";
    private final ReportQueue reportQueue;
    private final h transportTransform;
    private static final CrashlyticsReportJsonTransform TRANSFORM = new CrashlyticsReportJsonTransform();
    private static final String CRASHLYTICS_ENDPOINT = mergeStrings("hts/cahyiseot-agolai.o/1frlglgc/aclg", "tp:/rsltcrprsp.ogepscmv/ieo/eaybtho");
    private static final String CRASHLYTICS_API_KEY = mergeStrings("AzSBpY4F0rHiHFdinTvM", "IayrSTFL9eJ69YeSUO2");
    private static final h DEFAULT_TRANSFORM = new h() { // from class: com.google.firebase.crashlytics.internal.send.a
        @Override // X0.h
        public final Object apply(Object obj) {
            return DataTransportCrashlyticsReportSender.TRANSFORM.reportToJson((CrashlyticsReport) obj).getBytes(Charset.forName("UTF-8"));
        }
    };

    public DataTransportCrashlyticsReportSender(ReportQueue reportQueue, h hVar) {
        this.reportQueue = reportQueue;
        this.transportTransform = hVar;
    }

    public static DataTransportCrashlyticsReportSender create(Context context, SettingsProvider settingsProvider, OnDemandCounter onDemandCounter) {
        u.f(context);
        j jVarG = u.c().g(new Y0.a(CRASHLYTICS_ENDPOINT, CRASHLYTICS_API_KEY));
        X0.c cVarB = X0.c.b("json");
        h hVar = DEFAULT_TRANSFORM;
        return new DataTransportCrashlyticsReportSender(new ReportQueue(jVarG.a(CRASHLYTICS_TRANSPORT_NAME, CrashlyticsReport.class, cVarB, hVar), settingsProvider.getSettingsSync(), onDemandCounter), hVar);
    }

    private static String mergeStrings(String str, String str2) {
        int length = str.length() - str2.length();
        if (length < 0 || length > 1) {
            throw new IllegalArgumentException("Invalid input received");
        }
        StringBuilder sb = new StringBuilder(str.length() + str2.length());
        for (int i4 = 0; i4 < str.length(); i4++) {
            sb.append(str.charAt(i4));
            if (str2.length() > i4) {
                sb.append(str2.charAt(i4));
            }
        }
        return sb.toString();
    }

    public Task<CrashlyticsReportWithSessionId> enqueueReport(CrashlyticsReportWithSessionId crashlyticsReportWithSessionId, boolean z4) {
        return this.reportQueue.enqueueReport(crashlyticsReportWithSessionId, z4).getTask();
    }
}
