package com.google.android.gms.internal.measurement;

import H2.m;
import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.os.RemoteException;
import android.os.StrictMode;
import android.util.Log;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import u.C2736a;

/* JADX INFO: loaded from: classes.dex */
public final class zzjq implements zzju {
    private final ContentResolver zzc;
    private final Uri zzd;
    private final Runnable zze;
    private final ContentObserver zzf;
    private volatile Map zzh;
    private static final Map zzb = new C2736a();
    public static final String[] zza = {SubscriberAttributeKt.JSON_NAME_KEY, "value"};
    private final Object zzg = new Object();
    private final List zzi = new ArrayList();

    private zzjq(ContentResolver contentResolver, Uri uri, Runnable runnable) {
        m.n(contentResolver);
        m.n(uri);
        this.zzc = contentResolver;
        this.zzd = uri;
        this.zze = runnable;
        this.zzf = new zzjo(this, null);
    }

    public static zzjq zza(ContentResolver contentResolver, Uri uri, Runnable runnable) {
        zzjq zzjqVar;
        synchronized (zzjq.class) {
            Map map = zzb;
            zzjqVar = (zzjq) map.get(uri);
            if (zzjqVar == null) {
                try {
                    zzjq zzjqVar2 = new zzjq(contentResolver, uri, runnable);
                    try {
                        contentResolver.registerContentObserver(uri, false, zzjqVar2.zzf);
                        map.put(uri, zzjqVar2);
                    } catch (SecurityException unused) {
                    }
                    zzjqVar = zzjqVar2;
                } catch (SecurityException unused2) {
                }
            }
        }
        return zzjqVar;
    }

    public static synchronized void zzd() {
        try {
            Map map = zzb;
            for (zzjq zzjqVar : map.values()) {
                zzjqVar.zzc.unregisterContentObserver(zzjqVar.zzf);
            }
            map.clear();
        } catch (Throwable th) {
            throw th;
        }
    }

    public final Map zzb() {
        Map mapEmptyMap;
        Map map = this.zzh;
        if (map == null) {
            synchronized (this.zzg) {
                map = this.zzh;
                if (map == null) {
                    StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
                    try {
                        try {
                            mapEmptyMap = (Map) zzju.zzg(new zzjt() { // from class: com.google.android.gms.internal.measurement.zzjp
                                @Override // com.google.android.gms.internal.measurement.zzjt
                                public final /* synthetic */ Object zza() {
                                    return this.zza.zzf();
                                }
                            });
                        } finally {
                            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
                        }
                    } catch (SQLiteException | IllegalStateException | SecurityException e7) {
                        Log.w("ConfigurationContentLdr", "Unable to query ContentProvider, using default values", e7);
                        mapEmptyMap = Collections.emptyMap();
                    }
                    this.zzh = mapEmptyMap;
                    map = mapEmptyMap;
                }
            }
        }
        return map != null ? map : Collections.emptyMap();
    }

    public final void zzc() {
        synchronized (this.zzg) {
            this.zzh = null;
            this.zze.run();
        }
        synchronized (this) {
            try {
                Iterator it = this.zzi.iterator();
                while (it.hasNext()) {
                    ((zzjr) it.next()).zza();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzju
    public final /* bridge */ /* synthetic */ Object zze(String str) {
        return (String) zzb().get(str);
    }

    public final /* synthetic */ Map zzf() {
        Map mapEmptyMap;
        Cursor cursorQuery;
        Map mapEmptyMap2;
        ContentResolver contentResolver = this.zzc;
        Uri uri = this.zzd;
        ContentProviderClient contentProviderClientAcquireUnstableContentProviderClient = contentResolver.acquireUnstableContentProviderClient(uri);
        try {
            if (contentProviderClientAcquireUnstableContentProviderClient == null) {
                Log.w("ConfigurationContentLdr", "Unable to acquire ContentProviderClient, using default values");
                return Collections.emptyMap();
            }
            try {
                cursorQuery = contentProviderClientAcquireUnstableContentProviderClient.query(uri, zza, null, null, null);
                try {
                } catch (Throwable th) {
                    if (cursorQuery != null) {
                        try {
                            cursorQuery.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    }
                    throw th;
                }
            } catch (RemoteException e7) {
                Log.w("ConfigurationContentLdr", "ContentProvider query failed, using default values", e7);
                mapEmptyMap = Collections.emptyMap();
            }
            if (cursorQuery == null) {
                Log.w("ConfigurationContentLdr", "ContentProvider query returned null cursor, using default values");
                mapEmptyMap = Collections.emptyMap();
                contentProviderClientAcquireUnstableContentProviderClient.release();
                return mapEmptyMap;
            }
            int count = cursorQuery.getCount();
            if (count == 0) {
                mapEmptyMap2 = Collections.emptyMap();
            } else {
                Map c2736a = count <= 256 ? new C2736a(count) : new HashMap(count, 1.0f);
                while (cursorQuery.moveToNext()) {
                    c2736a.put(cursorQuery.getString(0), cursorQuery.getString(1));
                }
                if (cursorQuery.isAfterLast()) {
                    cursorQuery.close();
                    contentProviderClientAcquireUnstableContentProviderClient.release();
                    return c2736a;
                }
                Log.w("ConfigurationContentLdr", "Cursor read incomplete (ContentProvider dead?), using default values");
                mapEmptyMap2 = Collections.emptyMap();
            }
            cursorQuery.close();
            contentProviderClientAcquireUnstableContentProviderClient.release();
            return mapEmptyMap2;
        } catch (Throwable th3) {
            contentProviderClientAcquireUnstableContentProviderClient.release();
            throw th3;
        }
    }
}
