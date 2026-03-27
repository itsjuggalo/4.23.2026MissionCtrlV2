package com.revenuecat.purchases.common.diagnostics;

import com.revenuecat.purchases.common.FileHelper;
import com.revenuecat.purchases.utils.EventsFileHelper;
import kotlin.jvm.internal.AbstractC1585j;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes.dex */
public final class DiagnosticsFileHelper extends EventsFileHelper<DiagnosticsEntry> {
    public static final Companion Companion = new Companion(null);
    public static final int DIAGNOSTICS_FILE_LIMIT_IN_KB = 500;
    public static final String DIAGNOSTICS_FILE_PATH = "RevenueCat/diagnostics/diagnostic_entries.jsonl";
    public static final int DIAGNOSTICS_FILE_SYNC_LIMIT_IN_KB = 200;
    private final FileHelper fileHelper;

    public static final class Companion {
        public /* synthetic */ Companion(AbstractC1585j abstractC1585j) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DiagnosticsFileHelper(FileHelper fileHelper) {
        super(fileHelper, DIAGNOSTICS_FILE_PATH, null, null, 8, null);
        r.f(fileHelper, "fileHelper");
        this.fileHelper = fileHelper;
    }

    private final double diagnosticsFileSize() {
        return this.fileHelper.fileSizeInKB(DIAGNOSTICS_FILE_PATH);
    }

    public final synchronized boolean isDiagnosticsFileBigEnoughToSync() {
        return diagnosticsFileSize() > 200.0d;
    }

    public final synchronized boolean isDiagnosticsFileTooBig() {
        return diagnosticsFileSize() > 500.0d;
    }
}
