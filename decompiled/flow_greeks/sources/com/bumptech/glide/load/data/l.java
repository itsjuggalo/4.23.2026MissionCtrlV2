package com.bumptech.glide.load.data;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.util.Log;
import com.bumptech.glide.load.data.d;
import java.io.FileNotFoundException;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class l implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f5305a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Uri f5306b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ContentResolver f5307c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Object f5308d;

    public l(ContentResolver contentResolver, Uri uri, boolean z10) {
        this.f5307c = contentResolver;
        this.f5306b = uri;
        this.f5305a = z10;
    }

    @Override // com.bumptech.glide.load.data.d
    public void b() {
        Object obj = this.f5308d;
        if (obj != null) {
            try {
                c(obj);
            } catch (IOException unused) {
            }
        }
    }

    public abstract void c(Object obj);

    @Override // com.bumptech.glide.load.data.d
    public g3.a d() {
        return g3.a.LOCAL;
    }

    @Override // com.bumptech.glide.load.data.d
    public final void e(com.bumptech.glide.g gVar, d.a aVar) {
        try {
            Object objF = f(this.f5306b, this.f5307c);
            this.f5308d = objF;
            aVar.f(objF);
        } catch (FileNotFoundException e10) {
            if (Log.isLoggable("LocalUriFetcher", 3)) {
                Log.d("LocalUriFetcher", "Failed to open Uri", e10);
            }
            aVar.c(e10);
        }
    }

    public abstract Object f(Uri uri, ContentResolver contentResolver);

    public AssetFileDescriptor g(Uri uri) {
        return (this.f5305a && h3.b.d(uri) && h3.b.c()) ? h3.b.h(uri, this.f5307c) : this.f5307c.openAssetFileDescriptor(uri, "r");
    }

    @Override // com.bumptech.glide.load.data.d
    public void cancel() {
    }
}
