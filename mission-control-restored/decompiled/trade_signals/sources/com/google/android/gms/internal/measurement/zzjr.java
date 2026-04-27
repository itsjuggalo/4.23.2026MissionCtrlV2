package com.google.android.gms.internal.measurement;

import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.os.RemoteException;
import android.os.StrictMode;
import android.util.Log;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.function.Function;
import v2.AbstractC2848n;
import w.C2882a;

/* JADX INFO: loaded from: classes.dex */
public final class zzjr implements zzjv {
    private final ContentResolver zzc;
    private final Uri zzd;
    private final Runnable zze;
    private volatile Map zzi;
    private static final ConcurrentMap zzb = new ConcurrentHashMap();
    public static final String[] zza = {"key", "value"};
    private ContentObserver zzf = null;
    private volatile boolean zzg = true;
    private final Object zzh = new Object();
    private final List zzj = new ArrayList();

    private zzjr(ContentResolver contentResolver, Uri uri, Runnable runnable) {
        AbstractC2848n.n(contentResolver);
        AbstractC2848n.n(uri);
        this.zzc = contentResolver;
        this.zzd = uri;
        this.zze = runnable;
    }

    public static zzjr zza(final ContentResolver contentResolver, final Uri uri, final Runnable runnable) {
        zzjr zzjrVar = (zzjr) zzb.computeIfAbsent(uri, new Function() { // from class: com.google.android.gms.internal.measurement.zzjq
            @Override // java.util.function.Function
            public final /* synthetic */ Object apply(Object obj) {
                return zzjr.zzf(contentResolver, uri, runnable, (Uri) obj);
            }
        });
        try {
            if (zzjrVar.zzg) {
                synchronized (zzjrVar) {
                    try {
                        if (zzjrVar.zzg) {
                            zzjo zzjoVar = new zzjo(zzjrVar, null);
                            zzjrVar.zzc.registerContentObserver(zzjrVar.zzd, false, zzjoVar);
                            zzjrVar.zzf = zzjoVar;
                            zzjrVar.zzg = false;
                        }
                    } finally {
                    }
                }
            }
            return zzjrVar;
        } catch (SecurityException unused) {
            return null;
        }
    }

    public static void zzd() {
        Iterator it = zzb.values().iterator();
        while (it.hasNext()) {
            zzjr zzjrVar = (zzjr) it.next();
            synchronized (zzjrVar) {
                try {
                    if (zzjrVar.zzg) {
                        zzjrVar.zzg = false;
                    } else {
                        ContentObserver contentObserver = zzjrVar.zzf;
                        if (contentObserver != null) {
                            zzjrVar.zzc.unregisterContentObserver(contentObserver);
                            zzjrVar.zzf = null;
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            it.remove();
        }
    }

    public static /* synthetic */ zzjr zzf(ContentResolver contentResolver, Uri uri, Runnable runnable, Uri uri2) {
        return new zzjr(contentResolver, uri, runnable);
    }

    public final Map zzb() {
        Map mapEmptyMap;
        Map map = this.zzi;
        if (map == null) {
            synchronized (this.zzh) {
                map = this.zzi;
                if (map == null) {
                    StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
                    try {
                        try {
                            mapEmptyMap = (Map) zzjv.zzh(new zzju() { // from class: com.google.android.gms.internal.measurement.zzjp
                                @Override // com.google.android.gms.internal.measurement.zzju
                                public final /* synthetic */ Object zza() {
                                    return this.zza.zzg();
                                }
                            });
                        } finally {
                            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
                        }
                    } catch (SQLiteException | IllegalStateException | SecurityException e8) {
                        Log.w("ConfigurationContentLdr", "Unable to query ContentProvider, using default values", e8);
                        mapEmptyMap = Collections.emptyMap();
                    }
                    this.zzi = mapEmptyMap;
                    map = mapEmptyMap;
                }
            }
        }
        return map != null ? map : Collections.emptyMap();
    }

    public final void zzc() {
        synchronized (this.zzh) {
            this.zzi = null;
            this.zze.run();
        }
        synchronized (this) {
            try {
                Iterator it = this.zzj.iterator();
                while (it.hasNext()) {
                    ((zzjs) it.next()).zza();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzjv
    public final /* bridge */ /* synthetic */ Object zze(String str) {
        return (String) zzb().get(str);
    }

    public final /* synthetic */ Map zzg() {
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
            } catch (RemoteException e8) {
                Log.w("ConfigurationContentLdr", "ContentProvider query failed, using default values", e8);
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
                Map c2882a = count <= 256 ? new C2882a(count) : new HashMap(count, 1.0f);
                while (cursorQuery.moveToNext()) {
                    c2882a.put(cursorQuery.getString(0), cursorQuery.getString(1));
                }
                if (cursorQuery.isAfterLast()) {
                    cursorQuery.close();
                    contentProviderClientAcquireUnstableContentProviderClient.release();
                    return c2882a;
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
