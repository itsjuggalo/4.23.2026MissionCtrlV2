package com.google.firebase.storage;

import N1.B0;
import android.net.Uri;
import com.google.android.gms.common.internal.I;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import t2.u0;

/* JADX INFO: loaded from: classes.dex */
public final class m implements Comparable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Uri f5582a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f f5583b;

    public m(Uri uri, f fVar) {
        I.a("storageUri cannot be null", uri != null);
        I.a("FirebaseApp cannot be null", fVar != null);
        this.f5582a = uri;
        this.f5583b = fVar;
    }

    public final String a() {
        String path = this.f5582a.getPath();
        int iLastIndexOf = path.lastIndexOf(47);
        return iLastIndexOf != -1 ? path.substring(iLastIndexOf + 1) : path;
    }

    public final f.d b() {
        return new f.d(this.f5582a, this.f5583b.f5558h);
    }

    public final Task c(Integer num, String str) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        u0.f10210b.execute(new B0(this, num, str, taskCompletionSource));
        return taskCompletionSource.getTask();
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        return this.f5582a.compareTo(((m) obj).f5582a);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof m) {
            return ((m) obj).toString().equals(toString());
        }
        return false;
    }

    public final int hashCode() {
        return toString().hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("gs://");
        Uri uri = this.f5582a;
        sb.append(uri.getAuthority());
        sb.append(uri.getEncodedPath());
        return sb.toString();
    }
}
