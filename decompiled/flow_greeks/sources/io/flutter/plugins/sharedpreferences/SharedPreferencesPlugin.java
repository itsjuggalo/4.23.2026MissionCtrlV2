package io.flutter.plugins.sharedpreferences;

import android.content.Context;
import android.util.Log;
import cd.h0;
import com.revenuecat.purchases.common.networking.RCHTTPStatusCodes;
import dd.a0;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugins.sharedpreferences.SharedPreferencesAsyncApi;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.m0;
import ng.n0;
import p1.f;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004B\u0011\b\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0003\u0010\u0007J\u001f\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\u000eJ \u0010\u0012\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000fH\u0082@¢\u0006\u0004\b\u0012\u0010\u0013J,\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00170\u00162\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0014H\u0082@¢\u0006\u0004\b\u0018\u0010\u0019J\u001c\u0010\u001c\u001a\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u001b\u0018\u00010\u001aH\u0082@¢\u0006\u0004\b\u001c\u0010\u001dJ\u001e\u0010\u001e\u001a\u0004\u0018\u00010\u00172\n\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u001bH\u0082@¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010\"\u001a\u00020\f2\u0006\u0010!\u001a\u00020 H\u0016¢\u0006\u0004\b\"\u0010#J\u0017\u0010$\u001a\u00020\f2\u0006\u0010!\u001a\u00020 H\u0016¢\u0006\u0004\b$\u0010#J'\u0010(\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020%2\u0006\u0010'\u001a\u00020&H\u0016¢\u0006\u0004\b(\u0010)J'\u0010*\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010'\u001a\u00020&H\u0016¢\u0006\u0004\b*\u0010+J'\u0010-\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020,2\u0006\u0010'\u001a\u00020&H\u0016¢\u0006\u0004\b-\u0010.J'\u00100\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020/2\u0006\u0010'\u001a\u00020&H\u0016¢\u0006\u0004\b0\u00101J'\u00102\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010'\u001a\u00020&H\u0016¢\u0006\u0004\b2\u0010+J-\u00103\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000f2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00142\u0006\u0010'\u001a\u00020&H\u0017¢\u0006\u0004\b3\u00104J'\u00105\u001a\u00020\f2\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u00142\u0006\u0010'\u001a\u00020&H\u0016¢\u0006\u0004\b5\u00106J3\u00107\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00170\u00162\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u00142\u0006\u0010'\u001a\u00020&H\u0016¢\u0006\u0004\b7\u00108J!\u00109\u001a\u0004\u0018\u00010,2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010'\u001a\u00020&H\u0016¢\u0006\u0004\b9\u0010:J!\u0010;\u001a\u0004\u0018\u00010%2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010'\u001a\u00020&H\u0016¢\u0006\u0004\b;\u0010<J!\u0010=\u001a\u0004\u0018\u00010/2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010'\u001a\u00020&H\u0016¢\u0006\u0004\b=\u0010>J!\u0010?\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010'\u001a\u00020&H\u0016¢\u0006\u0004\b?\u0010@J!\u0010B\u001a\u0004\u0018\u00010A2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010'\u001a\u00020&H\u0016¢\u0006\u0004\bB\u0010CJ'\u0010D\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u00142\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010'\u001a\u00020&H\u0016¢\u0006\u0004\bD\u0010EJ-\u0010F\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00142\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u00142\u0006\u0010'\u001a\u00020&H\u0016¢\u0006\u0004\bF\u0010GR\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u000b\u0010HR\u0018\u0010J\u001a\u0004\u0018\u00010I8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bJ\u0010KR\u0016\u0010\u0006\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010L¨\u0006M"}, d2 = {"Lio/flutter/plugins/sharedpreferences/SharedPreferencesPlugin;", "Lio/flutter/embedding/engine/plugins/FlutterPlugin;", "Lio/flutter/plugins/sharedpreferences/SharedPreferencesAsyncApi;", "<init>", "()V", "Lio/flutter/plugins/sharedpreferences/SharedPreferencesListEncoder;", "listEncoder", "(Lio/flutter/plugins/sharedpreferences/SharedPreferencesListEncoder;)V", "Lio/flutter/plugin/common/BinaryMessenger;", "messenger", "Landroid/content/Context;", "context", "Lcd/h0;", "setUp", "(Lio/flutter/plugin/common/BinaryMessenger;Landroid/content/Context;)V", "", "key", "value", "dataStoreSetString", "(Ljava/lang/String;Ljava/lang/String;Lgd/e;)Ljava/lang/Object;", "", "allowList", "", "", "getPrefs", "(Ljava/util/List;Lgd/e;)Ljava/lang/Object;", "", "Lp1/f$a;", "readAllKeys", "(Lgd/e;)Ljava/lang/Object;", "getValueByKey", "(Lp1/f$a;Lgd/e;)Ljava/lang/Object;", "Lio/flutter/embedding/engine/plugins/FlutterPlugin$FlutterPluginBinding;", "binding", "onAttachedToEngine", "(Lio/flutter/embedding/engine/plugins/FlutterPlugin$FlutterPluginBinding;)V", "onDetachedFromEngine", "", "Lio/flutter/plugins/sharedpreferences/SharedPreferencesPigeonOptions;", "options", "setBool", "(Ljava/lang/String;ZLio/flutter/plugins/sharedpreferences/SharedPreferencesPigeonOptions;)V", "setString", "(Ljava/lang/String;Ljava/lang/String;Lio/flutter/plugins/sharedpreferences/SharedPreferencesPigeonOptions;)V", "", "setInt", "(Ljava/lang/String;JLio/flutter/plugins/sharedpreferences/SharedPreferencesPigeonOptions;)V", "", "setDouble", "(Ljava/lang/String;DLio/flutter/plugins/sharedpreferences/SharedPreferencesPigeonOptions;)V", "setEncodedStringList", "setDeprecatedStringList", "(Ljava/lang/String;Ljava/util/List;Lio/flutter/plugins/sharedpreferences/SharedPreferencesPigeonOptions;)V", "clear", "(Ljava/util/List;Lio/flutter/plugins/sharedpreferences/SharedPreferencesPigeonOptions;)V", "getAll", "(Ljava/util/List;Lio/flutter/plugins/sharedpreferences/SharedPreferencesPigeonOptions;)Ljava/util/Map;", "getInt", "(Ljava/lang/String;Lio/flutter/plugins/sharedpreferences/SharedPreferencesPigeonOptions;)Ljava/lang/Long;", "getBool", "(Ljava/lang/String;Lio/flutter/plugins/sharedpreferences/SharedPreferencesPigeonOptions;)Ljava/lang/Boolean;", "getDouble", "(Ljava/lang/String;Lio/flutter/plugins/sharedpreferences/SharedPreferencesPigeonOptions;)Ljava/lang/Double;", "getString", "(Ljava/lang/String;Lio/flutter/plugins/sharedpreferences/SharedPreferencesPigeonOptions;)Ljava/lang/String;", "Lio/flutter/plugins/sharedpreferences/StringListResult;", "getStringList", "(Ljava/lang/String;Lio/flutter/plugins/sharedpreferences/SharedPreferencesPigeonOptions;)Lio/flutter/plugins/sharedpreferences/StringListResult;", "getPlatformEncodedStringList", "(Ljava/lang/String;Lio/flutter/plugins/sharedpreferences/SharedPreferencesPigeonOptions;)Ljava/util/List;", "getKeys", "(Ljava/util/List;Lio/flutter/plugins/sharedpreferences/SharedPreferencesPigeonOptions;)Ljava/util/List;", "Landroid/content/Context;", "Lio/flutter/plugins/sharedpreferences/SharedPreferencesBackend;", "backend", "Lio/flutter/plugins/sharedpreferences/SharedPreferencesBackend;", "Lio/flutter/plugins/sharedpreferences/SharedPreferencesListEncoder;", "shared_preferences_android_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SharedPreferencesPlugin implements FlutterPlugin, SharedPreferencesAsyncApi {
    private SharedPreferencesBackend backend;
    private Context context;
    private SharedPreferencesListEncoder listEncoder;

    /* JADX INFO: renamed from: io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$clear$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lng/n0;", "Lp1/f;", "<anonymous>", "(Lng/n0;)Lp1/f;"}, k = 3, mv = {2, 1, 0})
    @id.f(c = "io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$clear$1", f = "SharedPreferencesPlugin.kt", l = {134}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends id.m implements pd.o {
        final /* synthetic */ List<String> $allowList;
        int label;

        /* JADX INFO: renamed from: io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$clear$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lp1/c;", "preferences", "Lcd/h0;", "<anonymous>", "(Lp1/c;)V"}, k = 3, mv = {2, 1, 0})
        @id.f(c = "io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$clear$1$1", f = "SharedPreferencesPlugin.kt", l = {}, m = "invokeSuspend")
        public static final class C02341 extends id.m implements pd.o {
            final /* synthetic */ List<String> $allowList;
            /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C02341(List<String> list, gd.e eVar) {
                super(2, eVar);
                this.$allowList = list;
            }

            @Override // id.a
            public final gd.e create(Object obj, gd.e eVar) {
                C02341 c02341 = new C02341(this.$allowList, eVar);
                c02341.L$0 = obj;
                return c02341;
            }

            @Override // id.a
            public final Object invokeSuspend(Object obj) throws Throwable {
                hd.c.f();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                cd.s.b(obj);
                p1.c cVar = (p1.c) this.L$0;
                List<String> list = this.$allowList;
                if (list != null) {
                    Iterator<T> it = list.iterator();
                    while (it.hasNext()) {
                        cVar.i(p1.i.a((String) it.next()));
                    }
                } else {
                    cVar.f();
                }
                return h0.f3852a;
            }

            @Override // pd.o
            public final Object invoke(p1.c cVar, gd.e eVar) {
                return ((C02341) create(cVar, eVar)).invokeSuspend(h0.f3852a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(List<String> list, gd.e eVar) {
            super(2, eVar);
            this.$allowList = list;
        }

        @Override // id.a
        public final gd.e create(Object obj, gd.e eVar) {
            return SharedPreferencesPlugin.this.new AnonymousClass1(this.$allowList, eVar);
        }

        @Override // id.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = hd.c.f();
            int i10 = this.label;
            if (i10 != 0) {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                cd.s.b(obj);
                return obj;
            }
            cd.s.b(obj);
            Context context = SharedPreferencesPlugin.this.context;
            if (context == null) {
                kotlin.jvm.internal.t.s("context");
                context = null;
            }
            l1.i sharedPreferencesDataStore = SharedPreferencesPluginKt.getSharedPreferencesDataStore(context);
            C02341 c02341 = new C02341(this.$allowList, null);
            this.label = 1;
            Object objA = p1.j.a(sharedPreferencesDataStore, c02341, this);
            return objA == objF ? objF : objA;
        }

        @Override // pd.o
        public final Object invoke(n0 n0Var, gd.e eVar) {
            return ((AnonymousClass1) create(n0Var, eVar)).invokeSuspend(h0.f3852a);
        }
    }

    /* JADX INFO: renamed from: io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$dataStoreSetString$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lp1/c;", "preferences", "Lcd/h0;", "<anonymous>", "(Lp1/c;)V"}, k = 3, mv = {2, 1, 0})
    @id.f(c = "io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$dataStoreSetString$2", f = "SharedPreferencesPlugin.kt", l = {}, m = "invokeSuspend")
    public static final class AnonymousClass2 extends id.m implements pd.o {
        final /* synthetic */ f.a $stringKey;
        final /* synthetic */ String $value;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(f.a aVar, String str, gd.e eVar) {
            super(2, eVar);
            this.$stringKey = aVar;
            this.$value = str;
        }

        @Override // id.a
        public final gd.e create(Object obj, gd.e eVar) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$stringKey, this.$value, eVar);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // id.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            hd.c.f();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            cd.s.b(obj);
            ((p1.c) this.L$0).j(this.$stringKey, this.$value);
            return h0.f3852a;
        }

        @Override // pd.o
        public final Object invoke(p1.c cVar, gd.e eVar) {
            return ((AnonymousClass2) create(cVar, eVar)).invokeSuspend(h0.f3852a);
        }
    }

    /* JADX INFO: renamed from: io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$getAll$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lng/n0;", "", "", "", "<anonymous>", "(Lng/n0;)Ljava/util/Map;"}, k = 3, mv = {2, 1, 0})
    @id.f(c = "io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$getAll$1", f = "SharedPreferencesPlugin.kt", l = {150}, m = "invokeSuspend")
    public static final class C06311 extends id.m implements pd.o {
        final /* synthetic */ List<String> $allowList;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C06311(List<String> list, gd.e eVar) {
            super(2, eVar);
            this.$allowList = list;
        }

        @Override // id.a
        public final gd.e create(Object obj, gd.e eVar) {
            return SharedPreferencesPlugin.this.new C06311(this.$allowList, eVar);
        }

        @Override // id.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = hd.c.f();
            int i10 = this.label;
            if (i10 != 0) {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                cd.s.b(obj);
                return obj;
            }
            cd.s.b(obj);
            SharedPreferencesPlugin sharedPreferencesPlugin = SharedPreferencesPlugin.this;
            List<String> list = this.$allowList;
            this.label = 1;
            Object prefs = sharedPreferencesPlugin.getPrefs(list, this);
            return prefs == objF ? objF : prefs;
        }

        @Override // pd.o
        public final Object invoke(n0 n0Var, gd.e eVar) {
            return ((C06311) create(n0Var, eVar)).invokeSuspend(h0.f3852a);
        }
    }

    /* JADX INFO: renamed from: io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$getBool$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lng/n0;", "Lcd/h0;", "<anonymous>", "(Lng/n0;)V"}, k = 3, mv = {2, 1, 0})
    @id.f(c = "io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$getBool$1", f = "SharedPreferencesPlugin.kt", l = {174}, m = "invokeSuspend")
    public static final class C06321 extends id.m implements pd.o {
        final /* synthetic */ String $key;
        final /* synthetic */ m0 $value;
        Object L$0;
        int label;
        final /* synthetic */ SharedPreferencesPlugin this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C06321(String str, SharedPreferencesPlugin sharedPreferencesPlugin, m0 m0Var, gd.e eVar) {
            super(2, eVar);
            this.$key = str;
            this.this$0 = sharedPreferencesPlugin;
            this.$value = m0Var;
        }

        @Override // id.a
        public final gd.e create(Object obj, gd.e eVar) {
            return new C06321(this.$key, this.this$0, this.$value, eVar);
        }

        @Override // id.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            m0 m0Var;
            Object objF = hd.c.f();
            int i10 = this.label;
            if (i10 == 0) {
                cd.s.b(obj);
                final f.a aVarA = p1.i.a(this.$key);
                Context context = this.this$0.context;
                if (context == null) {
                    kotlin.jvm.internal.t.s("context");
                    context = null;
                }
                final qg.d data = SharedPreferencesPluginKt.getSharedPreferencesDataStore(context).getData();
                qg.d dVar = new qg.d() { // from class: io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$getBool$1$invokeSuspend$$inlined$map$1

                    /* JADX INFO: renamed from: io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$getBool$1$invokeSuspend$$inlined$map$1$2, reason: invalid class name */
                    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
                    @Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "R", "value", "Lcd/h0;", "emit", "(Ljava/lang/Object;Lgd/e;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {2, 1, 0})
                    public static final class AnonymousClass2<T> implements qg.e {
                        final /* synthetic */ f.a $preferencesKey$inlined;
                        final /* synthetic */ qg.e $this_unsafeFlow;

                        /* JADX INFO: renamed from: io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$getBool$1$invokeSuspend$$inlined$map$1$2$1, reason: invalid class name */
                        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
                        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
                        @id.f(c = "io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$getBool$1$invokeSuspend$$inlined$map$1$2", f = "SharedPreferencesPlugin.kt", l = {223}, m = "emit")
                        public static final class AnonymousClass1 extends id.d {
                            Object L$0;
                            int label;
                            /* synthetic */ Object result;

                            public AnonymousClass1(gd.e eVar) {
                                super(eVar);
                            }

                            @Override // id.a
                            public final Object invokeSuspend(Object obj) {
                                this.result = obj;
                                this.label |= Integer.MIN_VALUE;
                                return AnonymousClass2.this.emit(null, this);
                            }
                        }

                        public AnonymousClass2(qg.e eVar, f.a aVar) {
                            this.$this_unsafeFlow = eVar;
                            this.$preferencesKey$inlined = aVar;
                        }

                        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                        @Override // qg.e
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                            To view partially-correct add '--show-bad-code' argument
                        */
                        public final java.lang.Object emit(java.lang.Object r5, gd.e r6) throws java.lang.Throwable {
                            /*
                                r4 = this;
                                boolean r0 = r6 instanceof io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$getBool$1$invokeSuspend$$inlined$map$1.AnonymousClass2.AnonymousClass1
                                if (r0 == 0) goto L13
                                r0 = r6
                                io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$getBool$1$invokeSuspend$$inlined$map$1$2$1 r0 = (io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$getBool$1$invokeSuspend$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                                int r1 = r0.label
                                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                                r3 = r1 & r2
                                if (r3 == 0) goto L13
                                int r1 = r1 - r2
                                r0.label = r1
                                goto L18
                            L13:
                                io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$getBool$1$invokeSuspend$$inlined$map$1$2$1 r0 = new io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$getBool$1$invokeSuspend$$inlined$map$1$2$1
                                r0.<init>(r6)
                            L18:
                                java.lang.Object r6 = r0.result
                                java.lang.Object r1 = hd.c.f()
                                int r2 = r0.label
                                r3 = 1
                                if (r2 == 0) goto L31
                                if (r2 != r3) goto L29
                                cd.s.b(r6)
                                goto L47
                            L29:
                                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                                java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                                r5.<init>(r6)
                                throw r5
                            L31:
                                cd.s.b(r6)
                                qg.e r6 = r4.$this_unsafeFlow
                                p1.f r5 = (p1.f) r5
                                p1.f$a r2 = r4.$preferencesKey$inlined
                                java.lang.Object r5 = r5.b(r2)
                                r0.label = r3
                                java.lang.Object r5 = r6.emit(r5, r0)
                                if (r5 != r1) goto L47
                                return r1
                            L47:
                                cd.h0 r5 = cd.h0.f3852a
                                return r5
                            */
                            throw new UnsupportedOperationException("Method not decompiled: io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$getBool$1$invokeSuspend$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, gd.e):java.lang.Object");
                        }
                    }

                    @Override // qg.d
                    public Object collect(qg.e eVar, gd.e eVar2) {
                        Object objCollect = data.collect(new AnonymousClass2(eVar, aVarA), eVar2);
                        return objCollect == hd.c.f() ? objCollect : h0.f3852a;
                    }
                };
                m0 m0Var2 = this.$value;
                this.L$0 = m0Var2;
                this.label = 1;
                Object objM = qg.f.m(dVar, this);
                if (objM == objF) {
                    return objF;
                }
                m0Var = m0Var2;
                obj = objM;
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                m0Var = (m0) this.L$0;
                cd.s.b(obj);
            }
            m0Var.f14947a = obj;
            return h0.f3852a;
        }

        @Override // pd.o
        public final Object invoke(n0 n0Var, gd.e eVar) {
            return ((C06321) create(n0Var, eVar)).invokeSuspend(h0.f3852a);
        }
    }

    /* JADX INFO: renamed from: io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$getDouble$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lng/n0;", "Lcd/h0;", "<anonymous>", "(Lng/n0;)V"}, k = 3, mv = {2, 1, 0})
    @id.f(c = "io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$getDouble$1", f = "SharedPreferencesPlugin.kt", l = {188}, m = "invokeSuspend")
    public static final class C06331 extends id.m implements pd.o {
        final /* synthetic */ String $key;
        final /* synthetic */ m0 $value;
        Object L$0;
        int label;
        final /* synthetic */ SharedPreferencesPlugin this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C06331(String str, SharedPreferencesPlugin sharedPreferencesPlugin, m0 m0Var, gd.e eVar) {
            super(2, eVar);
            this.$key = str;
            this.this$0 = sharedPreferencesPlugin;
            this.$value = m0Var;
        }

        @Override // id.a
        public final gd.e create(Object obj, gd.e eVar) {
            return new C06331(this.$key, this.this$0, this.$value, eVar);
        }

        @Override // id.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            m0 m0Var;
            Object objF = hd.c.f();
            int i10 = this.label;
            if (i10 == 0) {
                cd.s.b(obj);
                final f.a aVarG = p1.i.g(this.$key);
                Context context = this.this$0.context;
                if (context == null) {
                    kotlin.jvm.internal.t.s("context");
                    context = null;
                }
                final qg.d data = SharedPreferencesPluginKt.getSharedPreferencesDataStore(context).getData();
                final SharedPreferencesPlugin sharedPreferencesPlugin = this.this$0;
                qg.d dVar = new qg.d() { // from class: io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$getDouble$1$invokeSuspend$$inlined$map$1

                    /* JADX INFO: renamed from: io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$getDouble$1$invokeSuspend$$inlined$map$1$2, reason: invalid class name */
                    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
                    @Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "R", "value", "Lcd/h0;", "emit", "(Ljava/lang/Object;Lgd/e;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {2, 1, 0})
                    public static final class AnonymousClass2<T> implements qg.e {
                        final /* synthetic */ f.a $preferencesKey$inlined;
                        final /* synthetic */ qg.e $this_unsafeFlow;
                        final /* synthetic */ SharedPreferencesPlugin this$0;

                        /* JADX INFO: renamed from: io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$getDouble$1$invokeSuspend$$inlined$map$1$2$1, reason: invalid class name */
                        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
                        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
                        @id.f(c = "io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$getDouble$1$invokeSuspend$$inlined$map$1$2", f = "SharedPreferencesPlugin.kt", l = {223}, m = "emit")
                        public static final class AnonymousClass1 extends id.d {
                            Object L$0;
                            int label;
                            /* synthetic */ Object result;

                            public AnonymousClass1(gd.e eVar) {
                                super(eVar);
                            }

                            @Override // id.a
                            public final Object invokeSuspend(Object obj) {
                                this.result = obj;
                                this.label |= Integer.MIN_VALUE;
                                return AnonymousClass2.this.emit(null, this);
                            }
                        }

                        public AnonymousClass2(qg.e eVar, f.a aVar, SharedPreferencesPlugin sharedPreferencesPlugin) {
                            this.$this_unsafeFlow = eVar;
                            this.$preferencesKey$inlined = aVar;
                            this.this$0 = sharedPreferencesPlugin;
                        }

                        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                        @Override // qg.e
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                            To view partially-correct add '--show-bad-code' argument
                        */
                        public final java.lang.Object emit(java.lang.Object r5, gd.e r6) throws java.lang.Throwable {
                            /*
                                r4 = this;
                                boolean r0 = r6 instanceof io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$getDouble$1$invokeSuspend$$inlined$map$1.AnonymousClass2.AnonymousClass1
                                if (r0 == 0) goto L13
                                r0 = r6
                                io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$getDouble$1$invokeSuspend$$inlined$map$1$2$1 r0 = (io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$getDouble$1$invokeSuspend$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                                int r1 = r0.label
                                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                                r3 = r1 & r2
                                if (r3 == 0) goto L13
                                int r1 = r1 - r2
                                r0.label = r1
                                goto L18
                            L13:
                                io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$getDouble$1$invokeSuspend$$inlined$map$1$2$1 r0 = new io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$getDouble$1$invokeSuspend$$inlined$map$1$2$1
                                r0.<init>(r6)
                            L18:
                                java.lang.Object r6 = r0.result
                                java.lang.Object r1 = hd.c.f()
                                int r2 = r0.label
                                r3 = 1
                                if (r2 == 0) goto L31
                                if (r2 != r3) goto L29
                                cd.s.b(r6)
                                goto L53
                            L29:
                                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                                java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                                r5.<init>(r6)
                                throw r5
                            L31:
                                cd.s.b(r6)
                                qg.e r6 = r4.$this_unsafeFlow
                                p1.f r5 = (p1.f) r5
                                p1.f$a r2 = r4.$preferencesKey$inlined
                                java.lang.Object r5 = r5.b(r2)
                                io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin r2 = r4.this$0
                                io.flutter.plugins.sharedpreferences.SharedPreferencesListEncoder r2 = io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin.access$getListEncoder$p(r2)
                                java.lang.Object r5 = io.flutter.plugins.sharedpreferences.SharedPreferencesPluginKt.transformPref(r5, r2)
                                java.lang.Double r5 = (java.lang.Double) r5
                                r0.label = r3
                                java.lang.Object r5 = r6.emit(r5, r0)
                                if (r5 != r1) goto L53
                                return r1
                            L53:
                                cd.h0 r5 = cd.h0.f3852a
                                return r5
                            */
                            throw new UnsupportedOperationException("Method not decompiled: io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$getDouble$1$invokeSuspend$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, gd.e):java.lang.Object");
                        }
                    }

                    @Override // qg.d
                    public Object collect(qg.e eVar, gd.e eVar2) {
                        Object objCollect = data.collect(new AnonymousClass2(eVar, aVarG, sharedPreferencesPlugin), eVar2);
                        return objCollect == hd.c.f() ? objCollect : h0.f3852a;
                    }
                };
                m0 m0Var2 = this.$value;
                this.L$0 = m0Var2;
                this.label = 1;
                Object objM = qg.f.m(dVar, this);
                if (objM == objF) {
                    return objF;
                }
                m0Var = m0Var2;
                obj = objM;
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                m0Var = (m0) this.L$0;
                cd.s.b(obj);
            }
            m0Var.f14947a = obj;
            return h0.f3852a;
        }

        @Override // pd.o
        public final Object invoke(n0 n0Var, gd.e eVar) {
            return ((C06331) create(n0Var, eVar)).invokeSuspend(h0.f3852a);
        }
    }

    /* JADX INFO: renamed from: io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$getInt$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lng/n0;", "Lcd/h0;", "<anonymous>", "(Lng/n0;)V"}, k = 3, mv = {2, 1, 0})
    @id.f(c = "io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$getInt$1", f = "SharedPreferencesPlugin.kt", l = {160}, m = "invokeSuspend")
    public static final class C06341 extends id.m implements pd.o {
        final /* synthetic */ String $key;
        final /* synthetic */ m0 $value;
        Object L$0;
        int label;
        final /* synthetic */ SharedPreferencesPlugin this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C06341(String str, SharedPreferencesPlugin sharedPreferencesPlugin, m0 m0Var, gd.e eVar) {
            super(2, eVar);
            this.$key = str;
            this.this$0 = sharedPreferencesPlugin;
            this.$value = m0Var;
        }

        @Override // id.a
        public final gd.e create(Object obj, gd.e eVar) {
            return new C06341(this.$key, this.this$0, this.$value, eVar);
        }

        @Override // id.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            m0 m0Var;
            Object objF = hd.c.f();
            int i10 = this.label;
            if (i10 == 0) {
                cd.s.b(obj);
                final f.a aVarF = p1.i.f(this.$key);
                Context context = this.this$0.context;
                if (context == null) {
                    kotlin.jvm.internal.t.s("context");
                    context = null;
                }
                final qg.d data = SharedPreferencesPluginKt.getSharedPreferencesDataStore(context).getData();
                qg.d dVar = new qg.d() { // from class: io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$getInt$1$invokeSuspend$$inlined$map$1

                    /* JADX INFO: renamed from: io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$getInt$1$invokeSuspend$$inlined$map$1$2, reason: invalid class name */
                    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
                    @Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "R", "value", "Lcd/h0;", "emit", "(Ljava/lang/Object;Lgd/e;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {2, 1, 0})
                    public static final class AnonymousClass2<T> implements qg.e {
                        final /* synthetic */ f.a $preferencesKey$inlined;
                        final /* synthetic */ qg.e $this_unsafeFlow;

                        /* JADX INFO: renamed from: io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$getInt$1$invokeSuspend$$inlined$map$1$2$1, reason: invalid class name */
                        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
                        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
                        @id.f(c = "io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$getInt$1$invokeSuspend$$inlined$map$1$2", f = "SharedPreferencesPlugin.kt", l = {223}, m = "emit")
                        public static final class AnonymousClass1 extends id.d {
                            Object L$0;
                            int label;
                            /* synthetic */ Object result;

                            public AnonymousClass1(gd.e eVar) {
                                super(eVar);
                            }

                            @Override // id.a
                            public final Object invokeSuspend(Object obj) {
                                this.result = obj;
                                this.label |= Integer.MIN_VALUE;
                                return AnonymousClass2.this.emit(null, this);
                            }
                        }

                        public AnonymousClass2(qg.e eVar, f.a aVar) {
                            this.$this_unsafeFlow = eVar;
                            this.$preferencesKey$inlined = aVar;
                        }

                        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                        @Override // qg.e
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                            To view partially-correct add '--show-bad-code' argument
                        */
                        public final java.lang.Object emit(java.lang.Object r5, gd.e r6) throws java.lang.Throwable {
                            /*
                                r4 = this;
                                boolean r0 = r6 instanceof io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$getInt$1$invokeSuspend$$inlined$map$1.AnonymousClass2.AnonymousClass1
                                if (r0 == 0) goto L13
                                r0 = r6
                                io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$getInt$1$invokeSuspend$$inlined$map$1$2$1 r0 = (io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$getInt$1$invokeSuspend$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                                int r1 = r0.label
                                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                                r3 = r1 & r2
                                if (r3 == 0) goto L13
                                int r1 = r1 - r2
                                r0.label = r1
                                goto L18
                            L13:
                                io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$getInt$1$invokeSuspend$$inlined$map$1$2$1 r0 = new io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$getInt$1$invokeSuspend$$inlined$map$1$2$1
                                r0.<init>(r6)
                            L18:
                                java.lang.Object r6 = r0.result
                                java.lang.Object r1 = hd.c.f()
                                int r2 = r0.label
                                r3 = 1
                                if (r2 == 0) goto L31
                                if (r2 != r3) goto L29
                                cd.s.b(r6)
                                goto L47
                            L29:
                                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                                java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                                r5.<init>(r6)
                                throw r5
                            L31:
                                cd.s.b(r6)
                                qg.e r6 = r4.$this_unsafeFlow
                                p1.f r5 = (p1.f) r5
                                p1.f$a r2 = r4.$preferencesKey$inlined
                                java.lang.Object r5 = r5.b(r2)
                                r0.label = r3
                                java.lang.Object r5 = r6.emit(r5, r0)
                                if (r5 != r1) goto L47
                                return r1
                            L47:
                                cd.h0 r5 = cd.h0.f3852a
                                return r5
                            */
                            throw new UnsupportedOperationException("Method not decompiled: io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$getInt$1$invokeSuspend$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, gd.e):java.lang.Object");
                        }
                    }

                    @Override // qg.d
                    public Object collect(qg.e eVar, gd.e eVar2) {
                        Object objCollect = data.collect(new AnonymousClass2(eVar, aVarF), eVar2);
                        return objCollect == hd.c.f() ? objCollect : h0.f3852a;
                    }
                };
                m0 m0Var2 = this.$value;
                this.L$0 = m0Var2;
                this.label = 1;
                Object objM = qg.f.m(dVar, this);
                if (objM == objF) {
                    return objF;
                }
                m0Var = m0Var2;
                obj = objM;
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                m0Var = (m0) this.L$0;
                cd.s.b(obj);
            }
            m0Var.f14947a = obj;
            return h0.f3852a;
        }

        @Override // pd.o
        public final Object invoke(n0 n0Var, gd.e eVar) {
            return ((C06341) create(n0Var, eVar)).invokeSuspend(h0.f3852a);
        }
    }

    /* JADX INFO: renamed from: io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$getPrefs$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @id.f(c = "io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin", f = "SharedPreferencesPlugin.kt", l = {256, 258}, m = "getPrefs")
    public static final class C06351 extends id.d {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        public C06351(gd.e eVar) {
            super(eVar);
        }

        @Override // id.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SharedPreferencesPlugin.this.getPrefs(null, this);
        }
    }

    /* JADX INFO: renamed from: io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$getString$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lng/n0;", "Lcd/h0;", "<anonymous>", "(Lng/n0;)V"}, k = 3, mv = {2, 1, 0})
    @id.f(c = "io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$getString$1", f = "SharedPreferencesPlugin.kt", l = {RCHTTPStatusCodes.CREATED}, m = "invokeSuspend")
    public static final class C06361 extends id.m implements pd.o {
        final /* synthetic */ String $key;
        final /* synthetic */ m0 $value;
        Object L$0;
        int label;
        final /* synthetic */ SharedPreferencesPlugin this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C06361(String str, SharedPreferencesPlugin sharedPreferencesPlugin, m0 m0Var, gd.e eVar) {
            super(2, eVar);
            this.$key = str;
            this.this$0 = sharedPreferencesPlugin;
            this.$value = m0Var;
        }

        @Override // id.a
        public final gd.e create(Object obj, gd.e eVar) {
            return new C06361(this.$key, this.this$0, this.$value, eVar);
        }

        @Override // id.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            m0 m0Var;
            Object objF = hd.c.f();
            int i10 = this.label;
            if (i10 == 0) {
                cd.s.b(obj);
                final f.a aVarG = p1.i.g(this.$key);
                Context context = this.this$0.context;
                if (context == null) {
                    kotlin.jvm.internal.t.s("context");
                    context = null;
                }
                final qg.d data = SharedPreferencesPluginKt.getSharedPreferencesDataStore(context).getData();
                qg.d dVar = new qg.d() { // from class: io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$getString$1$invokeSuspend$$inlined$map$1

                    /* JADX INFO: renamed from: io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$getString$1$invokeSuspend$$inlined$map$1$2, reason: invalid class name */
                    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
                    @Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "R", "value", "Lcd/h0;", "emit", "(Ljava/lang/Object;Lgd/e;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {2, 1, 0})
                    public static final class AnonymousClass2<T> implements qg.e {
                        final /* synthetic */ f.a $preferencesKey$inlined;
                        final /* synthetic */ qg.e $this_unsafeFlow;

                        /* JADX INFO: renamed from: io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$getString$1$invokeSuspend$$inlined$map$1$2$1, reason: invalid class name */
                        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
                        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
                        @id.f(c = "io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$getString$1$invokeSuspend$$inlined$map$1$2", f = "SharedPreferencesPlugin.kt", l = {223}, m = "emit")
                        public static final class AnonymousClass1 extends id.d {
                            Object L$0;
                            int label;
                            /* synthetic */ Object result;

                            public AnonymousClass1(gd.e eVar) {
                                super(eVar);
                            }

                            @Override // id.a
                            public final Object invokeSuspend(Object obj) {
                                this.result = obj;
                                this.label |= Integer.MIN_VALUE;
                                return AnonymousClass2.this.emit(null, this);
                            }
                        }

                        public AnonymousClass2(qg.e eVar, f.a aVar) {
                            this.$this_unsafeFlow = eVar;
                            this.$preferencesKey$inlined = aVar;
                        }

                        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                        @Override // qg.e
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                            To view partially-correct add '--show-bad-code' argument
                        */
                        public final java.lang.Object emit(java.lang.Object r5, gd.e r6) throws java.lang.Throwable {
                            /*
                                r4 = this;
                                boolean r0 = r6 instanceof io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$getString$1$invokeSuspend$$inlined$map$1.AnonymousClass2.AnonymousClass1
                                if (r0 == 0) goto L13
                                r0 = r6
                                io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$getString$1$invokeSuspend$$inlined$map$1$2$1 r0 = (io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$getString$1$invokeSuspend$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                                int r1 = r0.label
                                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                                r3 = r1 & r2
                                if (r3 == 0) goto L13
                                int r1 = r1 - r2
                                r0.label = r1
                                goto L18
                            L13:
                                io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$getString$1$invokeSuspend$$inlined$map$1$2$1 r0 = new io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$getString$1$invokeSuspend$$inlined$map$1$2$1
                                r0.<init>(r6)
                            L18:
                                java.lang.Object r6 = r0.result
                                java.lang.Object r1 = hd.c.f()
                                int r2 = r0.label
                                r3 = 1
                                if (r2 == 0) goto L31
                                if (r2 != r3) goto L29
                                cd.s.b(r6)
                                goto L47
                            L29:
                                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                                java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                                r5.<init>(r6)
                                throw r5
                            L31:
                                cd.s.b(r6)
                                qg.e r6 = r4.$this_unsafeFlow
                                p1.f r5 = (p1.f) r5
                                p1.f$a r2 = r4.$preferencesKey$inlined
                                java.lang.Object r5 = r5.b(r2)
                                r0.label = r3
                                java.lang.Object r5 = r6.emit(r5, r0)
                                if (r5 != r1) goto L47
                                return r1
                            L47:
                                cd.h0 r5 = cd.h0.f3852a
                                return r5
                            */
                            throw new UnsupportedOperationException("Method not decompiled: io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$getString$1$invokeSuspend$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, gd.e):java.lang.Object");
                        }
                    }

                    @Override // qg.d
                    public Object collect(qg.e eVar, gd.e eVar2) {
                        Object objCollect = data.collect(new AnonymousClass2(eVar, aVarG), eVar2);
                        return objCollect == hd.c.f() ? objCollect : h0.f3852a;
                    }
                };
                m0 m0Var2 = this.$value;
                this.L$0 = m0Var2;
                this.label = 1;
                Object objM = qg.f.m(dVar, this);
                if (objM == objF) {
                    return objF;
                }
                m0Var = m0Var2;
                obj = objM;
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                m0Var = (m0) this.L$0;
                cd.s.b(obj);
            }
            m0Var.f14947a = obj;
            return h0.f3852a;
        }

        @Override // pd.o
        public final Object invoke(n0 n0Var, gd.e eVar) {
            return ((C06361) create(n0Var, eVar)).invokeSuspend(h0.f3852a);
        }
    }

    /* JADX INFO: renamed from: io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$setBool$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lng/n0;", "Lcd/h0;", "<anonymous>", "(Lng/n0;)V"}, k = 3, mv = {2, 1, 0})
    @id.f(c = "io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$setBool$1", f = "SharedPreferencesPlugin.kt", l = {81}, m = "invokeSuspend")
    public static final class C06371 extends id.m implements pd.o {
        final /* synthetic */ String $key;
        final /* synthetic */ boolean $value;
        int label;
        final /* synthetic */ SharedPreferencesPlugin this$0;

        /* JADX INFO: renamed from: io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$setBool$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lp1/c;", "preferences", "Lcd/h0;", "<anonymous>", "(Lp1/c;)V"}, k = 3, mv = {2, 1, 0})
        @id.f(c = "io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$setBool$1$1", f = "SharedPreferencesPlugin.kt", l = {}, m = "invokeSuspend")
        public static final class C02351 extends id.m implements pd.o {
            final /* synthetic */ f.a $boolKey;
            final /* synthetic */ boolean $value;
            /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C02351(f.a aVar, boolean z10, gd.e eVar) {
                super(2, eVar);
                this.$boolKey = aVar;
                this.$value = z10;
            }

            @Override // id.a
            public final gd.e create(Object obj, gd.e eVar) {
                C02351 c02351 = new C02351(this.$boolKey, this.$value, eVar);
                c02351.L$0 = obj;
                return c02351;
            }

            @Override // id.a
            public final Object invokeSuspend(Object obj) throws Throwable {
                hd.c.f();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                cd.s.b(obj);
                ((p1.c) this.L$0).j(this.$boolKey, id.b.a(this.$value));
                return h0.f3852a;
            }

            @Override // pd.o
            public final Object invoke(p1.c cVar, gd.e eVar) {
                return ((C02351) create(cVar, eVar)).invokeSuspend(h0.f3852a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C06371(String str, SharedPreferencesPlugin sharedPreferencesPlugin, boolean z10, gd.e eVar) {
            super(2, eVar);
            this.$key = str;
            this.this$0 = sharedPreferencesPlugin;
            this.$value = z10;
        }

        @Override // id.a
        public final gd.e create(Object obj, gd.e eVar) {
            return new C06371(this.$key, this.this$0, this.$value, eVar);
        }

        @Override // id.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = hd.c.f();
            int i10 = this.label;
            if (i10 == 0) {
                cd.s.b(obj);
                f.a aVarA = p1.i.a(this.$key);
                Context context = this.this$0.context;
                if (context == null) {
                    kotlin.jvm.internal.t.s("context");
                    context = null;
                }
                l1.i sharedPreferencesDataStore = SharedPreferencesPluginKt.getSharedPreferencesDataStore(context);
                C02351 c02351 = new C02351(aVarA, this.$value, null);
                this.label = 1;
                if (p1.j.a(sharedPreferencesDataStore, c02351, this) == objF) {
                    return objF;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                cd.s.b(obj);
            }
            return h0.f3852a;
        }

        @Override // pd.o
        public final Object invoke(n0 n0Var, gd.e eVar) {
            return ((C06371) create(n0Var, eVar)).invokeSuspend(h0.f3852a);
        }
    }

    /* JADX INFO: renamed from: io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$setDeprecatedStringList$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lng/n0;", "Lcd/h0;", "<anonymous>", "(Lng/n0;)V"}, k = 3, mv = {2, 1, 0})
    @id.f(c = "io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$setDeprecatedStringList$1", f = "SharedPreferencesPlugin.kt", l = {128}, m = "invokeSuspend")
    public static final class C06381 extends id.m implements pd.o {
        final /* synthetic */ String $key;
        final /* synthetic */ String $valueString;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C06381(String str, String str2, gd.e eVar) {
            super(2, eVar);
            this.$key = str;
            this.$valueString = str2;
        }

        @Override // id.a
        public final gd.e create(Object obj, gd.e eVar) {
            return SharedPreferencesPlugin.this.new C06381(this.$key, this.$valueString, eVar);
        }

        @Override // id.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = hd.c.f();
            int i10 = this.label;
            if (i10 == 0) {
                cd.s.b(obj);
                SharedPreferencesPlugin sharedPreferencesPlugin = SharedPreferencesPlugin.this;
                String str = this.$key;
                String str2 = this.$valueString;
                this.label = 1;
                if (sharedPreferencesPlugin.dataStoreSetString(str, str2, this) == objF) {
                    return objF;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                cd.s.b(obj);
            }
            return h0.f3852a;
        }

        @Override // pd.o
        public final Object invoke(n0 n0Var, gd.e eVar) {
            return ((C06381) create(n0Var, eVar)).invokeSuspend(h0.f3852a);
        }
    }

    /* JADX INFO: renamed from: io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$setDouble$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lng/n0;", "Lcd/h0;", "<anonymous>", "(Lng/n0;)V"}, k = 3, mv = {2, 1, 0})
    @id.f(c = "io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$setDouble$1", f = "SharedPreferencesPlugin.kt", l = {107}, m = "invokeSuspend")
    public static final class C06391 extends id.m implements pd.o {
        final /* synthetic */ String $key;
        final /* synthetic */ double $value;
        int label;
        final /* synthetic */ SharedPreferencesPlugin this$0;

        /* JADX INFO: renamed from: io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$setDouble$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lp1/c;", "preferences", "Lcd/h0;", "<anonymous>", "(Lp1/c;)V"}, k = 3, mv = {2, 1, 0})
        @id.f(c = "io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$setDouble$1$1", f = "SharedPreferencesPlugin.kt", l = {}, m = "invokeSuspend")
        public static final class C02361 extends id.m implements pd.o {
            final /* synthetic */ f.a $doubleKey;
            final /* synthetic */ double $value;
            /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C02361(f.a aVar, double d10, gd.e eVar) {
                super(2, eVar);
                this.$doubleKey = aVar;
                this.$value = d10;
            }

            @Override // id.a
            public final gd.e create(Object obj, gd.e eVar) {
                C02361 c02361 = new C02361(this.$doubleKey, this.$value, eVar);
                c02361.L$0 = obj;
                return c02361;
            }

            @Override // id.a
            public final Object invokeSuspend(Object obj) throws Throwable {
                hd.c.f();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                cd.s.b(obj);
                ((p1.c) this.L$0).j(this.$doubleKey, id.b.b(this.$value));
                return h0.f3852a;
            }

            @Override // pd.o
            public final Object invoke(p1.c cVar, gd.e eVar) {
                return ((C02361) create(cVar, eVar)).invokeSuspend(h0.f3852a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C06391(String str, SharedPreferencesPlugin sharedPreferencesPlugin, double d10, gd.e eVar) {
            super(2, eVar);
            this.$key = str;
            this.this$0 = sharedPreferencesPlugin;
            this.$value = d10;
        }

        @Override // id.a
        public final gd.e create(Object obj, gd.e eVar) {
            return new C06391(this.$key, this.this$0, this.$value, eVar);
        }

        @Override // id.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = hd.c.f();
            int i10 = this.label;
            if (i10 == 0) {
                cd.s.b(obj);
                f.a aVarC = p1.i.c(this.$key);
                Context context = this.this$0.context;
                if (context == null) {
                    kotlin.jvm.internal.t.s("context");
                    context = null;
                }
                l1.i sharedPreferencesDataStore = SharedPreferencesPluginKt.getSharedPreferencesDataStore(context);
                C02361 c02361 = new C02361(aVarC, this.$value, null);
                this.label = 1;
                if (p1.j.a(sharedPreferencesDataStore, c02361, this) == objF) {
                    return objF;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                cd.s.b(obj);
            }
            return h0.f3852a;
        }

        @Override // pd.o
        public final Object invoke(n0 n0Var, gd.e eVar) {
            return ((C06391) create(n0Var, eVar)).invokeSuspend(h0.f3852a);
        }
    }

    /* JADX INFO: renamed from: io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$setEncodedStringList$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lng/n0;", "Lcd/h0;", "<anonymous>", "(Lng/n0;)V"}, k = 3, mv = {2, 1, 0})
    @id.f(c = "io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$setEncodedStringList$1", f = "SharedPreferencesPlugin.kt", l = {117}, m = "invokeSuspend")
    public static final class C06401 extends id.m implements pd.o {
        final /* synthetic */ String $key;
        final /* synthetic */ String $value;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C06401(String str, String str2, gd.e eVar) {
            super(2, eVar);
            this.$key = str;
            this.$value = str2;
        }

        @Override // id.a
        public final gd.e create(Object obj, gd.e eVar) {
            return SharedPreferencesPlugin.this.new C06401(this.$key, this.$value, eVar);
        }

        @Override // id.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = hd.c.f();
            int i10 = this.label;
            if (i10 == 0) {
                cd.s.b(obj);
                SharedPreferencesPlugin sharedPreferencesPlugin = SharedPreferencesPlugin.this;
                String str = this.$key;
                String str2 = this.$value;
                this.label = 1;
                if (sharedPreferencesPlugin.dataStoreSetString(str, str2, this) == objF) {
                    return objF;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                cd.s.b(obj);
            }
            return h0.f3852a;
        }

        @Override // pd.o
        public final Object invoke(n0 n0Var, gd.e eVar) {
            return ((C06401) create(n0Var, eVar)).invokeSuspend(h0.f3852a);
        }
    }

    /* JADX INFO: renamed from: io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$setInt$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lng/n0;", "Lcd/h0;", "<anonymous>", "(Lng/n0;)V"}, k = 3, mv = {2, 1, 0})
    @id.f(c = "io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$setInt$1", f = "SharedPreferencesPlugin.kt", l = {99}, m = "invokeSuspend")
    public static final class C06411 extends id.m implements pd.o {
        final /* synthetic */ String $key;
        final /* synthetic */ long $value;
        int label;
        final /* synthetic */ SharedPreferencesPlugin this$0;

        /* JADX INFO: renamed from: io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$setInt$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lp1/c;", "preferences", "Lcd/h0;", "<anonymous>", "(Lp1/c;)V"}, k = 3, mv = {2, 1, 0})
        @id.f(c = "io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$setInt$1$1", f = "SharedPreferencesPlugin.kt", l = {}, m = "invokeSuspend")
        public static final class C02371 extends id.m implements pd.o {
            final /* synthetic */ f.a $intKey;
            final /* synthetic */ long $value;
            /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C02371(f.a aVar, long j10, gd.e eVar) {
                super(2, eVar);
                this.$intKey = aVar;
                this.$value = j10;
            }

            @Override // id.a
            public final gd.e create(Object obj, gd.e eVar) {
                C02371 c02371 = new C02371(this.$intKey, this.$value, eVar);
                c02371.L$0 = obj;
                return c02371;
            }

            @Override // id.a
            public final Object invokeSuspend(Object obj) throws Throwable {
                hd.c.f();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                cd.s.b(obj);
                ((p1.c) this.L$0).j(this.$intKey, id.b.d(this.$value));
                return h0.f3852a;
            }

            @Override // pd.o
            public final Object invoke(p1.c cVar, gd.e eVar) {
                return ((C02371) create(cVar, eVar)).invokeSuspend(h0.f3852a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C06411(String str, SharedPreferencesPlugin sharedPreferencesPlugin, long j10, gd.e eVar) {
            super(2, eVar);
            this.$key = str;
            this.this$0 = sharedPreferencesPlugin;
            this.$value = j10;
        }

        @Override // id.a
        public final gd.e create(Object obj, gd.e eVar) {
            return new C06411(this.$key, this.this$0, this.$value, eVar);
        }

        @Override // id.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = hd.c.f();
            int i10 = this.label;
            if (i10 == 0) {
                cd.s.b(obj);
                f.a aVarF = p1.i.f(this.$key);
                Context context = this.this$0.context;
                if (context == null) {
                    kotlin.jvm.internal.t.s("context");
                    context = null;
                }
                l1.i sharedPreferencesDataStore = SharedPreferencesPluginKt.getSharedPreferencesDataStore(context);
                C02371 c02371 = new C02371(aVarF, this.$value, null);
                this.label = 1;
                if (p1.j.a(sharedPreferencesDataStore, c02371, this) == objF) {
                    return objF;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                cd.s.b(obj);
            }
            return h0.f3852a;
        }

        @Override // pd.o
        public final Object invoke(n0 n0Var, gd.e eVar) {
            return ((C06411) create(n0Var, eVar)).invokeSuspend(h0.f3852a);
        }
    }

    /* JADX INFO: renamed from: io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$setString$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lng/n0;", "Lcd/h0;", "<anonymous>", "(Lng/n0;)V"}, k = 3, mv = {2, 1, 0})
    @id.f(c = "io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$setString$1", f = "SharedPreferencesPlugin.kt", l = {87}, m = "invokeSuspend")
    public static final class C06421 extends id.m implements pd.o {
        final /* synthetic */ String $key;
        final /* synthetic */ String $value;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C06421(String str, String str2, gd.e eVar) {
            super(2, eVar);
            this.$key = str;
            this.$value = str2;
        }

        @Override // id.a
        public final gd.e create(Object obj, gd.e eVar) {
            return SharedPreferencesPlugin.this.new C06421(this.$key, this.$value, eVar);
        }

        @Override // id.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = hd.c.f();
            int i10 = this.label;
            if (i10 == 0) {
                cd.s.b(obj);
                SharedPreferencesPlugin sharedPreferencesPlugin = SharedPreferencesPlugin.this;
                String str = this.$key;
                String str2 = this.$value;
                this.label = 1;
                if (sharedPreferencesPlugin.dataStoreSetString(str, str2, this) == objF) {
                    return objF;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                cd.s.b(obj);
            }
            return h0.f3852a;
        }

        @Override // pd.o
        public final Object invoke(n0 n0Var, gd.e eVar) {
            return ((C06421) create(n0Var, eVar)).invokeSuspend(h0.f3852a);
        }
    }

    public SharedPreferencesPlugin() {
        this.listEncoder = new ListEncoder();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object dataStoreSetString(String str, String str2, gd.e eVar) {
        f.a aVarG = p1.i.g(str);
        Context context = this.context;
        if (context == null) {
            kotlin.jvm.internal.t.s("context");
            context = null;
        }
        Object objA = p1.j.a(SharedPreferencesPluginKt.getSharedPreferencesDataStore(context), new AnonymousClass2(aVarG, str2, null), eVar);
        return objA == hd.c.f() ? objA : h0.f3852a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00a3, code lost:
    
        if (r10 == r1) goto L32;
     */
    /* JADX WARN: Removed duplicated region for block: B:30:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00c0 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x00a3 -> B:33:0x00a6). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object getPrefs(java.util.List<java.lang.String> r9, gd.e r10) throws java.lang.Throwable {
        /*
            r8 = this;
            boolean r0 = r10 instanceof io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin.C06351
            if (r0 == 0) goto L13
            r0 = r10
            io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$getPrefs$1 r0 = (io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin.C06351) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$getPrefs$1 r0 = new io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$getPrefs$1
            r0.<init>(r10)
        L18:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = hd.c.f()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L59
            if (r2 == r4) goto L49
            if (r2 != r3) goto L41
            java.lang.Object r9 = r0.L$4
            p1.f$a r9 = (p1.f.a) r9
            java.lang.Object r2 = r0.L$3
            java.util.Iterator r2 = (java.util.Iterator) r2
            java.lang.Object r4 = r0.L$2
            java.util.Map r4 = (java.util.Map) r4
            java.lang.Object r5 = r0.L$1
            java.util.Set r5 = (java.util.Set) r5
            java.lang.Object r6 = r0.L$0
            io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin r6 = (io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin) r6
            cd.s.b(r10)
            goto La6
        L41:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L49:
            java.lang.Object r9 = r0.L$2
            java.util.Map r9 = (java.util.Map) r9
            java.lang.Object r2 = r0.L$1
            java.util.Set r2 = (java.util.Set) r2
            java.lang.Object r4 = r0.L$0
            io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin r4 = (io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin) r4
            cd.s.b(r10)
            goto L7b
        L59:
            cd.s.b(r10)
            if (r9 == 0) goto L64
            java.util.Set r9 = dd.a0.N0(r9)
        L62:
            r2 = r9
            goto L66
        L64:
            r9 = 0
            goto L62
        L66:
            java.util.LinkedHashMap r9 = new java.util.LinkedHashMap
            r9.<init>()
            r0.L$0 = r8
            r0.L$1 = r2
            r0.L$2 = r9
            r0.label = r4
            java.lang.Object r10 = r8.readAllKeys(r0)
            if (r10 != r1) goto L7a
            goto La5
        L7a:
            r4 = r8
        L7b:
            java.util.Set r10 = (java.util.Set) r10
            if (r10 == 0) goto Lc1
            java.util.Iterator r10 = r10.iterator()
            r5 = r2
            r6 = r4
            r4 = r9
            r2 = r10
        L87:
            boolean r9 = r2.hasNext()
            if (r9 == 0) goto Lc0
            java.lang.Object r9 = r2.next()
            p1.f$a r9 = (p1.f.a) r9
            r0.L$0 = r6
            r0.L$1 = r5
            r0.L$2 = r4
            r0.L$3 = r2
            r0.L$4 = r9
            r0.label = r3
            java.lang.Object r10 = r6.getValueByKey(r9, r0)
            if (r10 != r1) goto La6
        La5:
            return r1
        La6:
            java.lang.String r7 = r9.toString()
            boolean r7 = io.flutter.plugins.sharedpreferences.SharedPreferencesPluginKt.preferencesFilter(r7, r10, r5)
            if (r7 == 0) goto L87
            io.flutter.plugins.sharedpreferences.SharedPreferencesListEncoder r7 = r6.listEncoder
            java.lang.Object r10 = io.flutter.plugins.sharedpreferences.SharedPreferencesPluginKt.transformPref(r10, r7)
            if (r10 == 0) goto L87
            java.lang.String r9 = r9.toString()
            r4.put(r9, r10)
            goto L87
        Lc0:
            return r4
        Lc1:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin.getPrefs(java.util.List, gd.e):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object getValueByKey(final f.a aVar, gd.e eVar) {
        Context context = this.context;
        if (context == null) {
            kotlin.jvm.internal.t.s("context");
            context = null;
        }
        final qg.d data = SharedPreferencesPluginKt.getSharedPreferencesDataStore(context).getData();
        return qg.f.m(new qg.d() { // from class: io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$getValueByKey$$inlined$map$1

            /* JADX INFO: renamed from: io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$getValueByKey$$inlined$map$1$2, reason: invalid class name */
            /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
            @Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "R", "value", "Lcd/h0;", "emit", "(Ljava/lang/Object;Lgd/e;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {2, 1, 0})
            public static final class AnonymousClass2<T> implements qg.e {
                final /* synthetic */ f.a $key$inlined;
                final /* synthetic */ qg.e $this_unsafeFlow;

                /* JADX INFO: renamed from: io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$getValueByKey$$inlined$map$1$2$1, reason: invalid class name */
                /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
                @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
                @id.f(c = "io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$getValueByKey$$inlined$map$1$2", f = "SharedPreferencesPlugin.kt", l = {223}, m = "emit")
                public static final class AnonymousClass1 extends id.d {
                    Object L$0;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(gd.e eVar) {
                        super(eVar);
                    }

                    @Override // id.a
                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(qg.e eVar, f.a aVar) {
                    this.$this_unsafeFlow = eVar;
                    this.$key$inlined = aVar;
                }

                /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                @Override // qg.e
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object emit(java.lang.Object r5, gd.e r6) throws java.lang.Throwable {
                    /*
                        r4 = this;
                        boolean r0 = r6 instanceof io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$getValueByKey$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r6
                        io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$getValueByKey$$inlined$map$1$2$1 r0 = (io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$getValueByKey$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$getValueByKey$$inlined$map$1$2$1 r0 = new io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$getValueByKey$$inlined$map$1$2$1
                        r0.<init>(r6)
                    L18:
                        java.lang.Object r6 = r0.result
                        java.lang.Object r1 = hd.c.f()
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        cd.s.b(r6)
                        goto L47
                    L29:
                        java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                        java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                        r5.<init>(r6)
                        throw r5
                    L31:
                        cd.s.b(r6)
                        qg.e r6 = r4.$this_unsafeFlow
                        p1.f r5 = (p1.f) r5
                        p1.f$a r2 = r4.$key$inlined
                        java.lang.Object r5 = r5.b(r2)
                        r0.label = r3
                        java.lang.Object r5 = r6.emit(r5, r0)
                        if (r5 != r1) goto L47
                        return r1
                    L47:
                        cd.h0 r5 = cd.h0.f3852a
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$getValueByKey$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, gd.e):java.lang.Object");
                }
            }

            @Override // qg.d
            public Object collect(qg.e eVar2, gd.e eVar3) {
                Object objCollect = data.collect(new AnonymousClass2(eVar2, aVar), eVar3);
                return objCollect == hd.c.f() ? objCollect : h0.f3852a;
            }
        }, eVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object readAllKeys(gd.e eVar) {
        Context context = this.context;
        if (context == null) {
            kotlin.jvm.internal.t.s("context");
            context = null;
        }
        final qg.d data = SharedPreferencesPluginKt.getSharedPreferencesDataStore(context).getData();
        return qg.f.m(new qg.d() { // from class: io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$readAllKeys$$inlined$map$1

            /* JADX INFO: renamed from: io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$readAllKeys$$inlined$map$1$2, reason: invalid class name */
            /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
            @Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "R", "value", "Lcd/h0;", "emit", "(Ljava/lang/Object;Lgd/e;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {2, 1, 0})
            public static final class AnonymousClass2<T> implements qg.e {
                final /* synthetic */ qg.e $this_unsafeFlow;

                /* JADX INFO: renamed from: io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$readAllKeys$$inlined$map$1$2$1, reason: invalid class name */
                /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
                @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
                @id.f(c = "io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$readAllKeys$$inlined$map$1$2", f = "SharedPreferencesPlugin.kt", l = {223}, m = "emit")
                public static final class AnonymousClass1 extends id.d {
                    Object L$0;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(gd.e eVar) {
                        super(eVar);
                    }

                    @Override // id.a
                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(qg.e eVar) {
                    this.$this_unsafeFlow = eVar;
                }

                /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                @Override // qg.e
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object emit(java.lang.Object r5, gd.e r6) throws java.lang.Throwable {
                    /*
                        r4 = this;
                        boolean r0 = r6 instanceof io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$readAllKeys$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r6
                        io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$readAllKeys$$inlined$map$1$2$1 r0 = (io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$readAllKeys$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$readAllKeys$$inlined$map$1$2$1 r0 = new io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$readAllKeys$$inlined$map$1$2$1
                        r0.<init>(r6)
                    L18:
                        java.lang.Object r6 = r0.result
                        java.lang.Object r1 = hd.c.f()
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        cd.s.b(r6)
                        goto L49
                    L29:
                        java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                        java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                        r5.<init>(r6)
                        throw r5
                    L31:
                        cd.s.b(r6)
                        qg.e r6 = r4.$this_unsafeFlow
                        p1.f r5 = (p1.f) r5
                        java.util.Map r5 = r5.a()
                        java.util.Set r5 = r5.keySet()
                        r0.label = r3
                        java.lang.Object r5 = r6.emit(r5, r0)
                        if (r5 != r1) goto L49
                        return r1
                    L49:
                        cd.h0 r5 = cd.h0.f3852a
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$readAllKeys$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, gd.e):java.lang.Object");
                }
            }

            @Override // qg.d
            public Object collect(qg.e eVar2, gd.e eVar3) {
                Object objCollect = data.collect(new AnonymousClass2(eVar2), eVar3);
                return objCollect == hd.c.f() ? objCollect : h0.f3852a;
            }
        }, eVar);
    }

    private final void setUp(BinaryMessenger messenger, Context context) {
        this.context = context;
        try {
            SharedPreferencesAsyncApi.INSTANCE.setUp(messenger, this, "data_store");
            this.backend = new SharedPreferencesBackend(messenger, context, this.listEncoder);
        } catch (Exception e10) {
            Log.e(SharedPreferencesPluginKt.TAG, "Received exception while setting up SharedPreferencesPlugin", e10);
        }
    }

    @Override // io.flutter.plugins.sharedpreferences.SharedPreferencesAsyncApi
    public void clear(List<String> allowList, SharedPreferencesPigeonOptions options) {
        kotlin.jvm.internal.t.f(options, "options");
        ng.j.b(null, new AnonymousClass1(allowList, null), 1, null);
    }

    @Override // io.flutter.plugins.sharedpreferences.SharedPreferencesAsyncApi
    public Map<String, Object> getAll(List<String> allowList, SharedPreferencesPigeonOptions options) {
        kotlin.jvm.internal.t.f(options, "options");
        return (Map) ng.j.b(null, new C06311(allowList, null), 1, null);
    }

    @Override // io.flutter.plugins.sharedpreferences.SharedPreferencesAsyncApi
    public Boolean getBool(String key, SharedPreferencesPigeonOptions options) {
        kotlin.jvm.internal.t.f(key, "key");
        kotlin.jvm.internal.t.f(options, "options");
        m0 m0Var = new m0();
        ng.j.b(null, new C06321(key, this, m0Var, null), 1, null);
        return (Boolean) m0Var.f14947a;
    }

    @Override // io.flutter.plugins.sharedpreferences.SharedPreferencesAsyncApi
    public Double getDouble(String key, SharedPreferencesPigeonOptions options) {
        kotlin.jvm.internal.t.f(key, "key");
        kotlin.jvm.internal.t.f(options, "options");
        m0 m0Var = new m0();
        ng.j.b(null, new C06331(key, this, m0Var, null), 1, null);
        return (Double) m0Var.f14947a;
    }

    @Override // io.flutter.plugins.sharedpreferences.SharedPreferencesAsyncApi
    public Long getInt(String key, SharedPreferencesPigeonOptions options) {
        kotlin.jvm.internal.t.f(key, "key");
        kotlin.jvm.internal.t.f(options, "options");
        m0 m0Var = new m0();
        ng.j.b(null, new C06341(key, this, m0Var, null), 1, null);
        return (Long) m0Var.f14947a;
    }

    @Override // io.flutter.plugins.sharedpreferences.SharedPreferencesAsyncApi
    public List<String> getKeys(List<String> allowList, SharedPreferencesPigeonOptions options) {
        kotlin.jvm.internal.t.f(options, "options");
        return a0.I0(((Map) ng.j.b(null, new SharedPreferencesPlugin$getKeys$prefs$1(this, allowList, null), 1, null)).keySet());
    }

    @Override // io.flutter.plugins.sharedpreferences.SharedPreferencesAsyncApi
    public List<String> getPlatformEncodedStringList(String key, SharedPreferencesPigeonOptions options) {
        List list;
        kotlin.jvm.internal.t.f(key, "key");
        kotlin.jvm.internal.t.f(options, "options");
        String string = getString(key, options);
        ArrayList arrayList = null;
        if (string != null && !kg.z.J(string, SharedPreferencesPluginKt.JSON_LIST_PREFIX, false, 2, null) && kg.z.J(string, SharedPreferencesPluginKt.LIST_PREFIX, false, 2, null) && (list = (List) SharedPreferencesPluginKt.transformPref(string, this.listEncoder)) != null) {
            arrayList = new ArrayList();
            for (Object obj : list) {
                if (obj instanceof String) {
                    arrayList.add(obj);
                }
            }
        }
        return arrayList;
    }

    @Override // io.flutter.plugins.sharedpreferences.SharedPreferencesAsyncApi
    public String getString(String key, SharedPreferencesPigeonOptions options) {
        kotlin.jvm.internal.t.f(key, "key");
        kotlin.jvm.internal.t.f(options, "options");
        m0 m0Var = new m0();
        ng.j.b(null, new C06361(key, this, m0Var, null), 1, null);
        return (String) m0Var.f14947a;
    }

    @Override // io.flutter.plugins.sharedpreferences.SharedPreferencesAsyncApi
    public StringListResult getStringList(String key, SharedPreferencesPigeonOptions options) {
        kotlin.jvm.internal.t.f(key, "key");
        kotlin.jvm.internal.t.f(options, "options");
        String string = getString(key, options);
        if (string != null) {
            return kg.z.J(string, SharedPreferencesPluginKt.JSON_LIST_PREFIX, false, 2, null) ? new StringListResult(string, StringListLookupResultType.JSON_ENCODED) : kg.z.J(string, SharedPreferencesPluginKt.LIST_PREFIX, false, 2, null) ? new StringListResult(null, StringListLookupResultType.PLATFORM_ENCODED) : new StringListResult(null, StringListLookupResultType.UNEXPECTED_STRING);
        }
        return null;
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding binding) {
        kotlin.jvm.internal.t.f(binding, "binding");
        BinaryMessenger binaryMessenger = binding.getBinaryMessenger();
        kotlin.jvm.internal.t.e(binaryMessenger, "getBinaryMessenger(...)");
        Context applicationContext = binding.getApplicationContext();
        kotlin.jvm.internal.t.e(applicationContext, "getApplicationContext(...)");
        setUp(binaryMessenger, applicationContext);
        new LegacySharedPreferencesPlugin().onAttachedToEngine(binding);
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding binding) {
        kotlin.jvm.internal.t.f(binding, "binding");
        SharedPreferencesAsyncApi.Companion companion = SharedPreferencesAsyncApi.INSTANCE;
        BinaryMessenger binaryMessenger = binding.getBinaryMessenger();
        kotlin.jvm.internal.t.e(binaryMessenger, "getBinaryMessenger(...)");
        companion.setUp(binaryMessenger, null, "data_store");
        SharedPreferencesBackend sharedPreferencesBackend = this.backend;
        if (sharedPreferencesBackend != null) {
            sharedPreferencesBackend.tearDown();
        }
        this.backend = null;
    }

    @Override // io.flutter.plugins.sharedpreferences.SharedPreferencesAsyncApi
    public void setBool(String key, boolean value, SharedPreferencesPigeonOptions options) {
        kotlin.jvm.internal.t.f(key, "key");
        kotlin.jvm.internal.t.f(options, "options");
        ng.j.b(null, new C06371(key, this, value, null), 1, null);
    }

    @Override // io.flutter.plugins.sharedpreferences.SharedPreferencesAsyncApi
    public void setDeprecatedStringList(String key, List<String> value, SharedPreferencesPigeonOptions options) {
        kotlin.jvm.internal.t.f(key, "key");
        kotlin.jvm.internal.t.f(value, "value");
        kotlin.jvm.internal.t.f(options, "options");
        ng.j.b(null, new C06381(key, SharedPreferencesPluginKt.LIST_PREFIX + this.listEncoder.encode(value), null), 1, null);
    }

    @Override // io.flutter.plugins.sharedpreferences.SharedPreferencesAsyncApi
    public void setDouble(String key, double value, SharedPreferencesPigeonOptions options) {
        kotlin.jvm.internal.t.f(key, "key");
        kotlin.jvm.internal.t.f(options, "options");
        ng.j.b(null, new C06391(key, this, value, null), 1, null);
    }

    @Override // io.flutter.plugins.sharedpreferences.SharedPreferencesAsyncApi
    public void setEncodedStringList(String key, String value, SharedPreferencesPigeonOptions options) {
        kotlin.jvm.internal.t.f(key, "key");
        kotlin.jvm.internal.t.f(value, "value");
        kotlin.jvm.internal.t.f(options, "options");
        ng.j.b(null, new C06401(key, value, null), 1, null);
    }

    @Override // io.flutter.plugins.sharedpreferences.SharedPreferencesAsyncApi
    public void setInt(String key, long value, SharedPreferencesPigeonOptions options) {
        kotlin.jvm.internal.t.f(key, "key");
        kotlin.jvm.internal.t.f(options, "options");
        ng.j.b(null, new C06411(key, this, value, null), 1, null);
    }

    @Override // io.flutter.plugins.sharedpreferences.SharedPreferencesAsyncApi
    public void setString(String key, String value, SharedPreferencesPigeonOptions options) {
        kotlin.jvm.internal.t.f(key, "key");
        kotlin.jvm.internal.t.f(value, "value");
        kotlin.jvm.internal.t.f(options, "options");
        ng.j.b(null, new C06421(key, value, null), 1, null);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SharedPreferencesPlugin(SharedPreferencesListEncoder listEncoder) {
        this();
        kotlin.jvm.internal.t.f(listEncoder, "listEncoder");
        this.listEncoder = listEncoder;
    }
}
