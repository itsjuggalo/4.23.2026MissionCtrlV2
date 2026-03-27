package com.bumptech.glide.load.data;

import android.content.ContentResolver;
import android.net.Uri;
import android.util.Log;
import com.bumptech.glide.load.data.d;
import java.io.FileNotFoundException;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public abstract class l implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Uri f14851a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ContentResolver f14852b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f14853c;

    public l(ContentResolver contentResolver, Uri uri) {
        this.f14852b = contentResolver;
        this.f14851a = uri;
    }

    @Override // com.bumptech.glide.load.data.d
    public void b() {
        Object obj = this.f14853c;
        if (obj != null) {
            try {
                c(obj);
            } catch (IOException unused) {
            }
        }
    }

    public abstract void c(Object obj);

    @Override // com.bumptech.glide.load.data.d
    public void cancel() {
    }

    @Override // com.bumptech.glide.load.data.d
    public U0.a d() {
        return U0.a.LOCAL;
    }

    @Override // com.bumptech.glide.load.data.d
    public final void e(com.bumptech.glide.g gVar, d.a aVar) {
        try {
            Object objF = f(this.f14851a, this.f14852b);
            this.f14853c = objF;
            aVar.f(objF);
        } catch (FileNotFoundException e8) {
            if (Log.isLoggable("LocalUriFetcher", 3)) {
                Log.d("LocalUriFetcher", "Failed to open Uri", e8);
            }
            aVar.c(e8);
        }
    }

    public abstract Object f(Uri uri, ContentResolver contentResolver);
}
