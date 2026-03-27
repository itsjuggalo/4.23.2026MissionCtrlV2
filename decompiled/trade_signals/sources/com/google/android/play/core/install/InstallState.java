package com.google.android.play.core.install;

import android.content.Intent;
import n2.C2412s;
import p2.C2546c;

/* JADX INFO: loaded from: classes.dex */
public abstract class InstallState {
    public static InstallState f(Intent intent, C2412s c2412s) {
        c2412s.a("List of extras in received intent needed by fromUpdateIntent:", new Object[0]);
        c2412s.a("Key: %s; value: %s", "install.status", Integer.valueOf(intent.getIntExtra("install.status", 0)));
        c2412s.a("Key: %s; value: %s", "error.code", Integer.valueOf(intent.getIntExtra("error.code", 0)));
        return new C2546c(intent.getIntExtra("install.status", 0), intent.getLongExtra("bytes.downloaded", 0L), intent.getLongExtra("total.bytes.to.download", 0L), intent.getIntExtra("error.code", 0), intent.getStringExtra("package.name"));
    }

    public abstract long a();

    public abstract int b();

    public abstract int c();

    public abstract String d();

    public abstract long e();
}
