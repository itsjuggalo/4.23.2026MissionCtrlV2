package com.bumptech.glide.load.data;

import android.content.res.AssetManager;
import android.util.Log;
import com.bumptech.glide.load.data.d;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public abstract class b implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f14827a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AssetManager f14828b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f14829c;

    public b(AssetManager assetManager, String str) {
        this.f14828b = assetManager;
        this.f14827a = str;
    }

    @Override // com.bumptech.glide.load.data.d
    public void b() {
        Object obj = this.f14829c;
        if (obj == null) {
            return;
        }
        try {
            c(obj);
        } catch (IOException unused) {
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
    public void e(com.bumptech.glide.g gVar, d.a aVar) {
        try {
            Object objF = f(this.f14828b, this.f14827a);
            this.f14829c = objF;
            aVar.f(objF);
        } catch (IOException e8) {
            if (Log.isLoggable("AssetPathFetcher", 3)) {
                Log.d("AssetPathFetcher", "Failed to load data from asset manager", e8);
            }
            aVar.c(e8);
        }
    }

    public abstract Object f(AssetManager assetManager, String str);
}
