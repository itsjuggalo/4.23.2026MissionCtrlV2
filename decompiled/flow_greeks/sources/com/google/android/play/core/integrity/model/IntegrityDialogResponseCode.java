package com.google.android.play.core.integrity.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
@Retention(RetentionPolicy.SOURCE)
public @interface IntegrityDialogResponseCode {
    public static final int DIALOG_CANCELLED = 2;
    public static final int DIALOG_FAILED = 1;
    public static final int DIALOG_SUCCESSFUL = 3;
    public static final int DIALOG_UNAVAILABLE = 0;
}
