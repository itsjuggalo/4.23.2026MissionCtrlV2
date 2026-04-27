package v0;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/* JADX INFO: renamed from: v0.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C2762a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Object f24740f = new Object();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static C2762a f24741g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f24742a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap f24743b = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashMap f24744c = new HashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ArrayList f24745d = new ArrayList();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Handler f24746e;

    /* JADX INFO: renamed from: v0.a$a, reason: collision with other inner class name */
    public class HandlerC0386a extends Handler {
        public HandlerC0386a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 1) {
                super.handleMessage(message);
            } else {
                C2762a.this.a();
            }
        }
    }

    /* JADX INFO: renamed from: v0.a$b */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Intent f24748a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ArrayList f24749b;

        public b(Intent intent, ArrayList arrayList) {
            this.f24748a = intent;
            this.f24749b = arrayList;
        }
    }

    /* JADX INFO: renamed from: v0.a$c */
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final IntentFilter f24750a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final BroadcastReceiver f24751b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f24752c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f24753d;

        public c(IntentFilter intentFilter, BroadcastReceiver broadcastReceiver) {
            this.f24750a = intentFilter;
            this.f24751b = broadcastReceiver;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(128);
            sb.append("Receiver{");
            sb.append(this.f24751b);
            sb.append(" filter=");
            sb.append(this.f24750a);
            if (this.f24753d) {
                sb.append(" DEAD");
            }
            sb.append("}");
            return sb.toString();
        }
    }

    public C2762a(Context context) {
        this.f24742a = context;
        this.f24746e = new HandlerC0386a(context.getMainLooper());
    }

    public static C2762a b(Context context) {
        C2762a c2762a;
        synchronized (f24740f) {
            try {
                if (f24741g == null) {
                    f24741g = new C2762a(context.getApplicationContext());
                }
                c2762a = f24741g;
            } catch (Throwable th) {
                throw th;
            }
        }
        return c2762a;
    }

    public void a() {
        int size;
        b[] bVarArr;
        while (true) {
            synchronized (this.f24743b) {
                try {
                    size = this.f24745d.size();
                    if (size <= 0) {
                        return;
                    }
                    bVarArr = new b[size];
                    this.f24745d.toArray(bVarArr);
                    this.f24745d.clear();
                } catch (Throwable th) {
                    throw th;
                }
            }
            for (int i7 = 0; i7 < size; i7++) {
                b bVar = bVarArr[i7];
                int size2 = bVar.f24749b.size();
                for (int i8 = 0; i8 < size2; i8++) {
                    c cVar = (c) bVar.f24749b.get(i8);
                    if (!cVar.f24753d) {
                        cVar.f24751b.onReceive(this.f24742a, bVar.f24748a);
                    }
                }
            }
        }
    }

    public void c(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        synchronized (this.f24743b) {
            try {
                c cVar = new c(intentFilter, broadcastReceiver);
                ArrayList arrayList = (ArrayList) this.f24743b.get(broadcastReceiver);
                if (arrayList == null) {
                    arrayList = new ArrayList(1);
                    this.f24743b.put(broadcastReceiver, arrayList);
                }
                arrayList.add(cVar);
                for (int i7 = 0; i7 < intentFilter.countActions(); i7++) {
                    String action = intentFilter.getAction(i7);
                    ArrayList arrayList2 = (ArrayList) this.f24744c.get(action);
                    if (arrayList2 == null) {
                        arrayList2 = new ArrayList(1);
                        this.f24744c.put(action, arrayList2);
                    }
                    arrayList2.add(cVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean d(Intent intent) {
        int i7;
        String str;
        ArrayList arrayList;
        ArrayList arrayList2;
        String str2;
        synchronized (this.f24743b) {
            try {
                String action = intent.getAction();
                String strResolveTypeIfNeeded = intent.resolveTypeIfNeeded(this.f24742a.getContentResolver());
                Uri data = intent.getData();
                String scheme = intent.getScheme();
                Set<String> categories = intent.getCategories();
                boolean z7 = (intent.getFlags() & 8) != 0;
                if (z7) {
                    Log.v("LocalBroadcastManager", "Resolving type " + strResolveTypeIfNeeded + " scheme " + scheme + " of intent " + intent);
                }
                ArrayList arrayList3 = (ArrayList) this.f24744c.get(intent.getAction());
                if (arrayList3 != null) {
                    if (z7) {
                        Log.v("LocalBroadcastManager", "Action list: " + arrayList3);
                    }
                    ArrayList arrayList4 = null;
                    int i8 = 0;
                    while (i8 < arrayList3.size()) {
                        c cVar = (c) arrayList3.get(i8);
                        if (z7) {
                            Log.v("LocalBroadcastManager", "Matching against filter " + cVar.f24750a);
                        }
                        if (cVar.f24752c) {
                            if (z7) {
                                Log.v("LocalBroadcastManager", "  Filter's target already added");
                            }
                            i7 = i8;
                            arrayList2 = arrayList3;
                            str = action;
                            str2 = strResolveTypeIfNeeded;
                            arrayList = arrayList4;
                        } else {
                            i7 = i8;
                            str = action;
                            arrayList = arrayList4;
                            arrayList2 = arrayList3;
                            str2 = strResolveTypeIfNeeded;
                            int iMatch = cVar.f24750a.match(action, strResolveTypeIfNeeded, scheme, data, categories, "LocalBroadcastManager");
                            if (iMatch >= 0) {
                                if (z7) {
                                    Log.v("LocalBroadcastManager", "  Filter matched!  match=0x" + Integer.toHexString(iMatch));
                                }
                                arrayList4 = arrayList == null ? new ArrayList() : arrayList;
                                arrayList4.add(cVar);
                                cVar.f24752c = true;
                                i8 = i7 + 1;
                                action = str;
                                arrayList3 = arrayList2;
                                strResolveTypeIfNeeded = str2;
                            } else if (z7) {
                                Log.v("LocalBroadcastManager", "  Filter did not match: " + (iMatch != -4 ? iMatch != -3 ? iMatch != -2 ? iMatch != -1 ? "unknown reason" : "type" : "data" : "action" : "category"));
                            }
                        }
                        arrayList4 = arrayList;
                        i8 = i7 + 1;
                        action = str;
                        arrayList3 = arrayList2;
                        strResolveTypeIfNeeded = str2;
                    }
                    ArrayList arrayList5 = arrayList4;
                    if (arrayList5 != null) {
                        for (int i9 = 0; i9 < arrayList5.size(); i9++) {
                            ((c) arrayList5.get(i9)).f24752c = false;
                        }
                        this.f24745d.add(new b(intent, arrayList5));
                        if (!this.f24746e.hasMessages(1)) {
                            this.f24746e.sendEmptyMessage(1);
                        }
                        return true;
                    }
                }
                return false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void e(BroadcastReceiver broadcastReceiver) {
        synchronized (this.f24743b) {
            try {
                ArrayList arrayList = (ArrayList) this.f24743b.remove(broadcastReceiver);
                if (arrayList == null) {
                    return;
                }
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    c cVar = (c) arrayList.get(size);
                    cVar.f24753d = true;
                    for (int i7 = 0; i7 < cVar.f24750a.countActions(); i7++) {
                        String action = cVar.f24750a.getAction(i7);
                        ArrayList arrayList2 = (ArrayList) this.f24744c.get(action);
                        if (arrayList2 != null) {
                            for (int size2 = arrayList2.size() - 1; size2 >= 0; size2--) {
                                c cVar2 = (c) arrayList2.get(size2);
                                if (cVar2.f24751b == broadcastReceiver) {
                                    cVar2.f24753d = true;
                                    arrayList2.remove(size2);
                                }
                            }
                            if (arrayList2.size() <= 0) {
                                this.f24744c.remove(action);
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
