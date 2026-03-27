package f0;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.google.firebase.messaging.Constants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/* JADX INFO: renamed from: f0.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1242a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Object f11521f = new Object();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static C1242a f11522g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f11523a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap f11524b = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashMap f11525c = new HashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ArrayList f11526d = new ArrayList();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Handler f11527e;

    /* JADX INFO: renamed from: f0.a$a, reason: collision with other inner class name */
    public class HandlerC0192a extends Handler {
        public HandlerC0192a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 1) {
                super.handleMessage(message);
            } else {
                C1242a.this.a();
            }
        }
    }

    /* JADX INFO: renamed from: f0.a$b */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Intent f11529a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ArrayList f11530b;

        public b(Intent intent, ArrayList arrayList) {
            this.f11529a = intent;
            this.f11530b = arrayList;
        }
    }

    /* JADX INFO: renamed from: f0.a$c */
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final IntentFilter f11531a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final BroadcastReceiver f11532b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f11533c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f11534d;

        public c(IntentFilter intentFilter, BroadcastReceiver broadcastReceiver) {
            this.f11531a = intentFilter;
            this.f11532b = broadcastReceiver;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(UserMetadata.MAX_ROLLOUT_ASSIGNMENTS);
            sb.append("Receiver{");
            sb.append(this.f11532b);
            sb.append(" filter=");
            sb.append(this.f11531a);
            if (this.f11534d) {
                sb.append(" DEAD");
            }
            sb.append("}");
            return sb.toString();
        }
    }

    public C1242a(Context context) {
        this.f11523a = context;
        this.f11527e = new HandlerC0192a(context.getMainLooper());
    }

    public static C1242a b(Context context) {
        C1242a c1242a;
        synchronized (f11521f) {
            try {
                if (f11522g == null) {
                    f11522g = new C1242a(context.getApplicationContext());
                }
                c1242a = f11522g;
            } catch (Throwable th) {
                throw th;
            }
        }
        return c1242a;
    }

    public void a() {
        int size;
        b[] bVarArr;
        while (true) {
            synchronized (this.f11524b) {
                try {
                    size = this.f11526d.size();
                    if (size <= 0) {
                        return;
                    }
                    bVarArr = new b[size];
                    this.f11526d.toArray(bVarArr);
                    this.f11526d.clear();
                } catch (Throwable th) {
                    throw th;
                }
            }
            for (int i4 = 0; i4 < size; i4++) {
                b bVar = bVarArr[i4];
                int size2 = bVar.f11530b.size();
                for (int i5 = 0; i5 < size2; i5++) {
                    c cVar = (c) bVar.f11530b.get(i5);
                    if (!cVar.f11534d) {
                        cVar.f11532b.onReceive(this.f11523a, bVar.f11529a);
                    }
                }
            }
        }
    }

    public void c(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        synchronized (this.f11524b) {
            try {
                c cVar = new c(intentFilter, broadcastReceiver);
                ArrayList arrayList = (ArrayList) this.f11524b.get(broadcastReceiver);
                if (arrayList == null) {
                    arrayList = new ArrayList(1);
                    this.f11524b.put(broadcastReceiver, arrayList);
                }
                arrayList.add(cVar);
                for (int i4 = 0; i4 < intentFilter.countActions(); i4++) {
                    String action = intentFilter.getAction(i4);
                    ArrayList arrayList2 = (ArrayList) this.f11525c.get(action);
                    if (arrayList2 == null) {
                        arrayList2 = new ArrayList(1);
                        this.f11525c.put(action, arrayList2);
                    }
                    arrayList2.add(cVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean d(Intent intent) {
        String str;
        synchronized (this.f11524b) {
            try {
                String action = intent.getAction();
                String strResolveTypeIfNeeded = intent.resolveTypeIfNeeded(this.f11523a.getContentResolver());
                Uri data = intent.getData();
                String scheme = intent.getScheme();
                Set<String> categories = intent.getCategories();
                boolean z4 = (intent.getFlags() & 8) != 0;
                if (z4) {
                    Log.v("LocalBroadcastManager", "Resolving type " + strResolveTypeIfNeeded + " scheme " + scheme + " of intent " + intent);
                }
                ArrayList arrayList = (ArrayList) this.f11525c.get(intent.getAction());
                if (arrayList != null) {
                    if (z4) {
                        Log.v("LocalBroadcastManager", "Action list: " + arrayList);
                    }
                    ArrayList arrayList2 = null;
                    int i4 = 0;
                    while (i4 < arrayList.size()) {
                        c cVar = (c) arrayList.get(i4);
                        if (z4) {
                            Log.v("LocalBroadcastManager", "Matching against filter " + cVar.f11531a);
                        }
                        if (cVar.f11533c) {
                            if (z4) {
                                Log.v("LocalBroadcastManager", "  Filter's target already added");
                            }
                            str = action;
                        } else {
                            int iMatch = cVar.f11531a.match(action, strResolveTypeIfNeeded, scheme, data, categories, "LocalBroadcastManager");
                            if (iMatch >= 0) {
                                if (z4) {
                                    StringBuilder sb = new StringBuilder();
                                    str = action;
                                    sb.append("  Filter matched!  match=0x");
                                    sb.append(Integer.toHexString(iMatch));
                                    Log.v("LocalBroadcastManager", sb.toString());
                                } else {
                                    str = action;
                                }
                                if (arrayList2 == null) {
                                    arrayList2 = new ArrayList();
                                }
                                arrayList2.add(cVar);
                                cVar.f11533c = true;
                            } else {
                                str = action;
                                if (z4) {
                                    Log.v("LocalBroadcastManager", "  Filter did not match: " + (iMatch != -4 ? iMatch != -3 ? iMatch != -2 ? iMatch != -1 ? "unknown reason" : "type" : Constants.ScionAnalytics.MessageType.DATA_MESSAGE : "action" : "category"));
                                }
                            }
                        }
                        i4++;
                        action = str;
                    }
                    if (arrayList2 != null) {
                        for (int i5 = 0; i5 < arrayList2.size(); i5++) {
                            ((c) arrayList2.get(i5)).f11533c = false;
                        }
                        this.f11526d.add(new b(intent, arrayList2));
                        if (!this.f11527e.hasMessages(1)) {
                            this.f11527e.sendEmptyMessage(1);
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
        synchronized (this.f11524b) {
            try {
                ArrayList arrayList = (ArrayList) this.f11524b.remove(broadcastReceiver);
                if (arrayList == null) {
                    return;
                }
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    c cVar = (c) arrayList.get(size);
                    cVar.f11534d = true;
                    for (int i4 = 0; i4 < cVar.f11531a.countActions(); i4++) {
                        String action = cVar.f11531a.getAction(i4);
                        ArrayList arrayList2 = (ArrayList) this.f11525c.get(action);
                        if (arrayList2 != null) {
                            for (int size2 = arrayList2.size() - 1; size2 >= 0; size2--) {
                                c cVar2 = (c) arrayList2.get(size2);
                                if (cVar2.f11532b == broadcastReceiver) {
                                    cVar2.f11534d = true;
                                    arrayList2.remove(size2);
                                }
                            }
                            if (arrayList2.size() <= 0) {
                                this.f11525c.remove(action);
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
