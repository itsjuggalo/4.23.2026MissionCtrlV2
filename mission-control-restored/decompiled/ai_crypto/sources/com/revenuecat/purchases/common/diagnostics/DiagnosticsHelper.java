package com.revenuecat.purchases.common.diagnostics;

import E5.j;
import E5.k;
import android.content.Context;
import android.content.SharedPreferences;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.AbstractC2148j;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.s;

/* JADX INFO: loaded from: classes2.dex */
public final class DiagnosticsHelper {
    public static final String CONSECUTIVE_FAILURES_COUNT_KEY = "consecutive_failures_count";
    public static final Companion Companion = new Companion(null);
    private final DiagnosticsFileHelper diagnosticsFileHelper;
    private final j sharedPreferences;

    /* JADX INFO: renamed from: com.revenuecat.purchases.common.diagnostics.DiagnosticsHelper$1, reason: invalid class name */
    public static final class AnonymousClass1 extends s implements Function0 {
        final /* synthetic */ Context $context;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Context context) {
            super(0);
            this.$context = context;
        }

        @Override // kotlin.jvm.functions.Function0
        public final SharedPreferences invoke() {
            return DiagnosticsHelper.Companion.initializeSharedPreferences(this.$context);
        }
    }

    public static final class Companion {
        public /* synthetic */ Companion(AbstractC2148j abstractC2148j) {
            this();
        }

        public static /* synthetic */ void getCONSECUTIVE_FAILURES_COUNT_KEY$annotations() {
        }

        public final SharedPreferences initializeSharedPreferences(Context context) {
            r.f(context, "context");
            SharedPreferences sharedPreferences = context.getSharedPreferences("com_revenuecat_purchases_" + context.getPackageName() + "_preferences_diagnostics", 0);
            r.e(sharedPreferences, "context.getSharedPrefere…DE_PRIVATE,\n            )");
            return sharedPreferences;
        }

        private Companion() {
        }
    }

    public DiagnosticsHelper(Context context, DiagnosticsFileHelper diagnosticsFileHelper, j sharedPreferences) {
        r.f(context, "context");
        r.f(diagnosticsFileHelper, "diagnosticsFileHelper");
        r.f(sharedPreferences, "sharedPreferences");
        this.diagnosticsFileHelper = diagnosticsFileHelper;
        this.sharedPreferences = sharedPreferences;
    }

    public final void clearConsecutiveNumberOfErrors() {
        ((SharedPreferences) this.sharedPreferences.getValue()).edit().remove(CONSECUTIVE_FAILURES_COUNT_KEY).apply();
    }

    public final int increaseConsecutiveNumberOfErrors() {
        int i7 = ((SharedPreferences) this.sharedPreferences.getValue()).getInt(CONSECUTIVE_FAILURES_COUNT_KEY, 0) + 1;
        ((SharedPreferences) this.sharedPreferences.getValue()).edit().putInt(CONSECUTIVE_FAILURES_COUNT_KEY, i7).apply();
        return i7;
    }

    public final void resetDiagnosticsStatus() {
        clearConsecutiveNumberOfErrors();
        this.diagnosticsFileHelper.deleteFile();
    }

    public /* synthetic */ DiagnosticsHelper(Context context, DiagnosticsFileHelper diagnosticsFileHelper, j jVar, int i7, AbstractC2148j abstractC2148j) {
        this(context, diagnosticsFileHelper, (i7 & 4) != 0 ? k.b(new AnonymousClass1(context)) : jVar);
    }
}
