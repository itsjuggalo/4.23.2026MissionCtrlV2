package io.flutter.plugins.sharedpreferences;

import S.InterfaceC0523i;
import V.f;
import W2.E;
import a3.AbstractC0787c;
import android.content.Context;
import android.util.Log;
import b3.AbstractC0864b;
import b3.AbstractC0866d;
import b3.InterfaceC0868f;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.revenuecat.purchases.common.networking.RCHTTPStatusCodes;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugins.sharedpreferences.SharedPreferencesAsyncApi;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.F;
import t3.AbstractC1820j;
import t3.L;

/* JADX INFO: loaded from: classes3.dex */
public final class SharedPreferencesPlugin implements FlutterPlugin, SharedPreferencesAsyncApi {
    private SharedPreferencesBackend backend;
    private Context context;
    private SharedPreferencesListEncoder listEncoder;

    /* JADX INFO: renamed from: io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$clear$1, reason: invalid class name */
    @InterfaceC0868f(c = "io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$clear$1", f = "SharedPreferencesPlugin.kt", l = {134}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends b3.l implements i3.o {
        final /* synthetic */ List<String> $allowList;
        int label;

        /* JADX INFO: renamed from: io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$clear$1$1, reason: invalid class name and collision with other inner class name */
        @InterfaceC0868f(c = "io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$clear$1$1", f = "SharedPreferencesPlugin.kt", l = {}, m = "invokeSuspend")
        public static final class C02031 extends b3.l implements i3.o {
            final /* synthetic */ List<String> $allowList;
            /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C02031(List<String> list, Z2.e eVar) {
                super(2, eVar);
                this.$allowList = list;
            }

            @Override // b3.AbstractC0863a
            public final Z2.e create(Object obj, Z2.e eVar) {
                C02031 c02031 = new C02031(this.$allowList, eVar);
                c02031.L$0 = obj;
                return c02031;
            }

            @Override // i3.o
            public final Object invoke(V.c cVar, Z2.e eVar) {
                return ((C02031) create(cVar, eVar)).invokeSuspend(E.f5463a);
            }

            @Override // b3.AbstractC0863a
            public final Object invokeSuspend(Object obj) throws Throwable {
                AbstractC0787c.e();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                W2.q.b(obj);
                V.c cVar = (V.c) this.L$0;
                List<String> list = this.$allowList;
                if (list != null) {
                    Iterator<T> it = list.iterator();
                    while (it.hasNext()) {
                        cVar.i(V.i.a((String) it.next()));
                    }
                } else {
                    cVar.f();
                }
                return E.f5463a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(List<String> list, Z2.e eVar) {
            super(2, eVar);
            this.$allowList = list;
        }

        @Override // b3.AbstractC0863a
        public final Z2.e create(Object obj, Z2.e eVar) {
            return SharedPreferencesPlugin.this.new AnonymousClass1(this.$allowList, eVar);
        }

        @Override // b3.AbstractC0863a
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objE = AbstractC0787c.e();
            int i4 = this.label;
            if (i4 != 0) {
                if (i4 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                W2.q.b(obj);
                return obj;
            }
            W2.q.b(obj);
            Context context = SharedPreferencesPlugin.this.context;
            if (context == null) {
                kotlin.jvm.internal.r.t("context");
                context = null;
            }
            InterfaceC0523i sharedPreferencesDataStore = SharedPreferencesPluginKt.getSharedPreferencesDataStore(context);
            C02031 c02031 = new C02031(this.$allowList, null);
            this.label = 1;
            Object objA = V.j.a(sharedPreferencesDataStore, c02031, this);
            return objA == objE ? objE : objA;
        }

        @Override // i3.o
        public final Object invoke(L l4, Z2.e eVar) {
            return ((AnonymousClass1) create(l4, eVar)).invokeSuspend(E.f5463a);
        }
    }

    /* JADX INFO: renamed from: io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$dataStoreSetString$2, reason: invalid class name */
    @InterfaceC0868f(c = "io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$dataStoreSetString$2", f = "SharedPreferencesPlugin.kt", l = {}, m = "invokeSuspend")
    public static final class AnonymousClass2 extends b3.l implements i3.o {
        final /* synthetic */ f.a $stringKey;
        final /* synthetic */ String $value;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(f.a aVar, String str, Z2.e eVar) {
            super(2, eVar);
            this.$stringKey = aVar;
            this.$value = str;
        }

        @Override // b3.AbstractC0863a
        public final Z2.e create(Object obj, Z2.e eVar) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$stringKey, this.$value, eVar);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // i3.o
        public final Object invoke(V.c cVar, Z2.e eVar) {
            return ((AnonymousClass2) create(cVar, eVar)).invokeSuspend(E.f5463a);
        }

        @Override // b3.AbstractC0863a
        public final Object invokeSuspend(Object obj) throws Throwable {
            AbstractC0787c.e();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            W2.q.b(obj);
            ((V.c) this.L$0).j(this.$stringKey, this.$value);
            return E.f5463a;
        }
    }

    /* JADX INFO: renamed from: io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$getAll$1, reason: invalid class name and case insensitive filesystem */
    @InterfaceC0868f(c = "io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$getAll$1", f = "SharedPreferencesPlugin.kt", l = {150}, m = "invokeSuspend")
    public static final class C14271 extends b3.l implements i3.o {
        final /* synthetic */ List<String> $allowList;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C14271(List<String> list, Z2.e eVar) {
            super(2, eVar);
            this.$allowList = list;
        }

        @Override // b3.AbstractC0863a
        public final Z2.e create(Object obj, Z2.e eVar) {
            return SharedPreferencesPlugin.this.new C14271(this.$allowList, eVar);
        }

        @Override // b3.AbstractC0863a
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objE = AbstractC0787c.e();
            int i4 = this.label;
            if (i4 != 0) {
                if (i4 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                W2.q.b(obj);
                return obj;
            }
            W2.q.b(obj);
            SharedPreferencesPlugin sharedPreferencesPlugin = SharedPreferencesPlugin.this;
            List<String> list = this.$allowList;
            this.label = 1;
            Object prefs = sharedPreferencesPlugin.getPrefs(list, this);
            return prefs == objE ? objE : prefs;
        }

        @Override // i3.o
        public final Object invoke(L l4, Z2.e eVar) {
            return ((C14271) create(l4, eVar)).invokeSuspend(E.f5463a);
        }
    }

    /* JADX INFO: renamed from: io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$getBool$1, reason: invalid class name and case insensitive filesystem */
    @InterfaceC0868f(c = "io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$getBool$1", f = "SharedPreferencesPlugin.kt", l = {174}, m = "invokeSuspend")
    public static final class C14281 extends b3.l implements i3.o {
        final /* synthetic */ String $key;
        final /* synthetic */ F $value;
        Object L$0;
        int label;
        final /* synthetic */ SharedPreferencesPlugin this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C14281(String str, SharedPreferencesPlugin sharedPreferencesPlugin, F f4, Z2.e eVar) {
            super(2, eVar);
            this.$key = str;
            this.this$0 = sharedPreferencesPlugin;
            this.$value = f4;
        }

        @Override // b3.AbstractC0863a
        public final Z2.e create(Object obj, Z2.e eVar) {
            return new C14281(this.$key, this.this$0, this.$value, eVar);
        }

        @Override // b3.AbstractC0863a
        public final Object invokeSuspend(Object obj) throws Throwable {
            F f4;
            Object objE = AbstractC0787c.e();
            int i4 = this.label;
            if (i4 == 0) {
                W2.q.b(obj);
                final f.a aVarA = V.i.a(this.$key);
                Context context = this.this$0.context;
                if (context == null) {
                    kotlin.jvm.internal.r.t("context");
                    context = null;
                }
                final w3.d data = SharedPreferencesPluginKt.getSharedPreferencesDataStore(context).getData();
                w3.d dVar = new w3.d() { // from class: io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$getBool$1$invokeSuspend$$inlined$map$1

                    /* JADX INFO: renamed from: io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$getBool$1$invokeSuspend$$inlined$map$1$2, reason: invalid class name */
                    public static final class AnonymousClass2<T> implements w3.e {
                        final /* synthetic */ f.a $preferencesKey$inlined;
                        final /* synthetic */ w3.e $this_unsafeFlow;

                        /* JADX INFO: renamed from: io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$getBool$1$invokeSuspend$$inlined$map$1$2$1, reason: invalid class name */
                        @InterfaceC0868f(c = "io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$getBool$1$invokeSuspend$$inlined$map$1$2", f = "SharedPreferencesPlugin.kt", l = {223}, m = "emit")
                        public static final class AnonymousClass1 extends AbstractC0866d {
                            Object L$0;
                            int label;
                            /* synthetic */ Object result;

                            public AnonymousClass1(Z2.e eVar) {
                                super(eVar);
                            }

                            @Override // b3.AbstractC0863a
                            public final Object invokeSuspend(Object obj) {
                                this.result = obj;
                                this.label |= Integer.MIN_VALUE;
                                return AnonymousClass2.this.emit(null, this);
                            }
                        }

                        public AnonymousClass2(w3.e eVar, f.a aVar) {
                            this.$this_unsafeFlow = eVar;
                            this.$preferencesKey$inlined = aVar;
                        }

                        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                        @Override // w3.e
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                            To view partially-correct add '--show-bad-code' argument
                        */
                        public final java.lang.Object emit(java.lang.Object r5, Z2.e r6) throws java.lang.Throwable {
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
                                java.lang.Object r1 = a3.AbstractC0787c.e()
                                int r2 = r0.label
                                r3 = 1
                                if (r2 == 0) goto L31
                                if (r2 != r3) goto L29
                                W2.q.b(r6)
                                goto L47
                            L29:
                                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                                java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                                r5.<init>(r6)
                                throw r5
                            L31:
                                W2.q.b(r6)
                                w3.e r6 = r4.$this_unsafeFlow
                                V.f r5 = (V.f) r5
                                V.f$a r2 = r4.$preferencesKey$inlined
                                java.lang.Object r5 = r5.b(r2)
                                r0.label = r3
                                java.lang.Object r5 = r6.emit(r5, r0)
                                if (r5 != r1) goto L47
                                return r1
                            L47:
                                W2.E r5 = W2.E.f5463a
                                return r5
                            */
                            throw new UnsupportedOperationException("Method not decompiled: io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$getBool$1$invokeSuspend$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, Z2.e):java.lang.Object");
                        }
                    }

                    @Override // w3.d
                    public Object collect(w3.e eVar, Z2.e eVar2) {
                        Object objCollect = data.collect(new AnonymousClass2(eVar, aVarA), eVar2);
                        return objCollect == AbstractC0787c.e() ? objCollect : E.f5463a;
                    }
                };
                F f5 = this.$value;
                this.L$0 = f5;
                this.label = 1;
                Object objL = w3.f.l(dVar, this);
                if (objL == objE) {
                    return objE;
                }
                f4 = f5;
                obj = objL;
            } else {
                if (i4 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                f4 = (F) this.L$0;
                W2.q.b(obj);
            }
            f4.f13410a = obj;
            return E.f5463a;
        }

        @Override // i3.o
        public final Object invoke(L l4, Z2.e eVar) {
            return ((C14281) create(l4, eVar)).invokeSuspend(E.f5463a);
        }
    }

    /* JADX INFO: renamed from: io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$getDouble$1, reason: invalid class name and case insensitive filesystem */
    @InterfaceC0868f(c = "io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$getDouble$1", f = "SharedPreferencesPlugin.kt", l = {188}, m = "invokeSuspend")
    public static final class C14291 extends b3.l implements i3.o {
        final /* synthetic */ String $key;
        final /* synthetic */ F $value;
        Object L$0;
        int label;
        final /* synthetic */ SharedPreferencesPlugin this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C14291(String str, SharedPreferencesPlugin sharedPreferencesPlugin, F f4, Z2.e eVar) {
            super(2, eVar);
            this.$key = str;
            this.this$0 = sharedPreferencesPlugin;
            this.$value = f4;
        }

        @Override // b3.AbstractC0863a
        public final Z2.e create(Object obj, Z2.e eVar) {
            return new C14291(this.$key, this.this$0, this.$value, eVar);
        }

        @Override // b3.AbstractC0863a
        public final Object invokeSuspend(Object obj) throws Throwable {
            F f4;
            Object objE = AbstractC0787c.e();
            int i4 = this.label;
            if (i4 == 0) {
                W2.q.b(obj);
                final f.a aVarG = V.i.g(this.$key);
                Context context = this.this$0.context;
                if (context == null) {
                    kotlin.jvm.internal.r.t("context");
                    context = null;
                }
                final w3.d data = SharedPreferencesPluginKt.getSharedPreferencesDataStore(context).getData();
                final SharedPreferencesPlugin sharedPreferencesPlugin = this.this$0;
                w3.d dVar = new w3.d() { // from class: io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$getDouble$1$invokeSuspend$$inlined$map$1

                    /* JADX INFO: renamed from: io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$getDouble$1$invokeSuspend$$inlined$map$1$2, reason: invalid class name */
                    public static final class AnonymousClass2<T> implements w3.e {
                        final /* synthetic */ f.a $preferencesKey$inlined;
                        final /* synthetic */ w3.e $this_unsafeFlow;
                        final /* synthetic */ SharedPreferencesPlugin this$0;

                        /* JADX INFO: renamed from: io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$getDouble$1$invokeSuspend$$inlined$map$1$2$1, reason: invalid class name */
                        @InterfaceC0868f(c = "io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$getDouble$1$invokeSuspend$$inlined$map$1$2", f = "SharedPreferencesPlugin.kt", l = {223}, m = "emit")
                        public static final class AnonymousClass1 extends AbstractC0866d {
                            Object L$0;
                            int label;
                            /* synthetic */ Object result;

                            public AnonymousClass1(Z2.e eVar) {
                                super(eVar);
                            }

                            @Override // b3.AbstractC0863a
                            public final Object invokeSuspend(Object obj) {
                                this.result = obj;
                                this.label |= Integer.MIN_VALUE;
                                return AnonymousClass2.this.emit(null, this);
                            }
                        }

                        public AnonymousClass2(w3.e eVar, f.a aVar, SharedPreferencesPlugin sharedPreferencesPlugin) {
                            this.$this_unsafeFlow = eVar;
                            this.$preferencesKey$inlined = aVar;
                            this.this$0 = sharedPreferencesPlugin;
                        }

                        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                        @Override // w3.e
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                            To view partially-correct add '--show-bad-code' argument
                        */
                        public final java.lang.Object emit(java.lang.Object r5, Z2.e r6) throws java.lang.Throwable {
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
                                java.lang.Object r1 = a3.AbstractC0787c.e()
                                int r2 = r0.label
                                r3 = 1
                                if (r2 == 0) goto L31
                                if (r2 != r3) goto L29
                                W2.q.b(r6)
                                goto L53
                            L29:
                                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                                java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                                r5.<init>(r6)
                                throw r5
                            L31:
                                W2.q.b(r6)
                                w3.e r6 = r4.$this_unsafeFlow
                                V.f r5 = (V.f) r5
                                V.f$a r2 = r4.$preferencesKey$inlined
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
                                W2.E r5 = W2.E.f5463a
                                return r5
                            */
                            throw new UnsupportedOperationException("Method not decompiled: io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$getDouble$1$invokeSuspend$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, Z2.e):java.lang.Object");
                        }
                    }

                    @Override // w3.d
                    public Object collect(w3.e eVar, Z2.e eVar2) {
                        Object objCollect = data.collect(new AnonymousClass2(eVar, aVarG, sharedPreferencesPlugin), eVar2);
                        return objCollect == AbstractC0787c.e() ? objCollect : E.f5463a;
                    }
                };
                F f5 = this.$value;
                this.L$0 = f5;
                this.label = 1;
                Object objL = w3.f.l(dVar, this);
                if (objL == objE) {
                    return objE;
                }
                f4 = f5;
                obj = objL;
            } else {
                if (i4 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                f4 = (F) this.L$0;
                W2.q.b(obj);
            }
            f4.f13410a = obj;
            return E.f5463a;
        }

        @Override // i3.o
        public final Object invoke(L l4, Z2.e eVar) {
            return ((C14291) create(l4, eVar)).invokeSuspend(E.f5463a);
        }
    }

    /* JADX INFO: renamed from: io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$getInt$1, reason: invalid class name and case insensitive filesystem */
    @InterfaceC0868f(c = "io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$getInt$1", f = "SharedPreferencesPlugin.kt", l = {160}, m = "invokeSuspend")
    public static final class C14301 extends b3.l implements i3.o {
        final /* synthetic */ String $key;
        final /* synthetic */ F $value;
        Object L$0;
        int label;
        final /* synthetic */ SharedPreferencesPlugin this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C14301(String str, SharedPreferencesPlugin sharedPreferencesPlugin, F f4, Z2.e eVar) {
            super(2, eVar);
            this.$key = str;
            this.this$0 = sharedPreferencesPlugin;
            this.$value = f4;
        }

        @Override // b3.AbstractC0863a
        public final Z2.e create(Object obj, Z2.e eVar) {
            return new C14301(this.$key, this.this$0, this.$value, eVar);
        }

        @Override // b3.AbstractC0863a
        public final Object invokeSuspend(Object obj) throws Throwable {
            F f4;
            Object objE = AbstractC0787c.e();
            int i4 = this.label;
            if (i4 == 0) {
                W2.q.b(obj);
                final f.a aVarF = V.i.f(this.$key);
                Context context = this.this$0.context;
                if (context == null) {
                    kotlin.jvm.internal.r.t("context");
                    context = null;
                }
                final w3.d data = SharedPreferencesPluginKt.getSharedPreferencesDataStore(context).getData();
                w3.d dVar = new w3.d() { // from class: io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$getInt$1$invokeSuspend$$inlined$map$1

                    /* JADX INFO: renamed from: io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$getInt$1$invokeSuspend$$inlined$map$1$2, reason: invalid class name */
                    public static final class AnonymousClass2<T> implements w3.e {
                        final /* synthetic */ f.a $preferencesKey$inlined;
                        final /* synthetic */ w3.e $this_unsafeFlow;

                        /* JADX INFO: renamed from: io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$getInt$1$invokeSuspend$$inlined$map$1$2$1, reason: invalid class name */
                        @InterfaceC0868f(c = "io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$getInt$1$invokeSuspend$$inlined$map$1$2", f = "SharedPreferencesPlugin.kt", l = {223}, m = "emit")
                        public static final class AnonymousClass1 extends AbstractC0866d {
                            Object L$0;
                            int label;
                            /* synthetic */ Object result;

                            public AnonymousClass1(Z2.e eVar) {
                                super(eVar);
                            }

                            @Override // b3.AbstractC0863a
                            public final Object invokeSuspend(Object obj) {
                                this.result = obj;
                                this.label |= Integer.MIN_VALUE;
                                return AnonymousClass2.this.emit(null, this);
                            }
                        }

                        public AnonymousClass2(w3.e eVar, f.a aVar) {
                            this.$this_unsafeFlow = eVar;
                            this.$preferencesKey$inlined = aVar;
                        }

                        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                        @Override // w3.e
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                            To view partially-correct add '--show-bad-code' argument
                        */
                        public final java.lang.Object emit(java.lang.Object r5, Z2.e r6) throws java.lang.Throwable {
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
                                java.lang.Object r1 = a3.AbstractC0787c.e()
                                int r2 = r0.label
                                r3 = 1
                                if (r2 == 0) goto L31
                                if (r2 != r3) goto L29
                                W2.q.b(r6)
                                goto L47
                            L29:
                                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                                java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                                r5.<init>(r6)
                                throw r5
                            L31:
                                W2.q.b(r6)
                                w3.e r6 = r4.$this_unsafeFlow
                                V.f r5 = (V.f) r5
                                V.f$a r2 = r4.$preferencesKey$inlined
                                java.lang.Object r5 = r5.b(r2)
                                r0.label = r3
                                java.lang.Object r5 = r6.emit(r5, r0)
                                if (r5 != r1) goto L47
                                return r1
                            L47:
                                W2.E r5 = W2.E.f5463a
                                return r5
                            */
                            throw new UnsupportedOperationException("Method not decompiled: io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$getInt$1$invokeSuspend$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, Z2.e):java.lang.Object");
                        }
                    }

                    @Override // w3.d
                    public Object collect(w3.e eVar, Z2.e eVar2) {
                        Object objCollect = data.collect(new AnonymousClass2(eVar, aVarF), eVar2);
                        return objCollect == AbstractC0787c.e() ? objCollect : E.f5463a;
                    }
                };
                F f5 = this.$value;
                this.L$0 = f5;
                this.label = 1;
                Object objL = w3.f.l(dVar, this);
                if (objL == objE) {
                    return objE;
                }
                f4 = f5;
                obj = objL;
            } else {
                if (i4 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                f4 = (F) this.L$0;
                W2.q.b(obj);
            }
            f4.f13410a = obj;
            return E.f5463a;
        }

        @Override // i3.o
        public final Object invoke(L l4, Z2.e eVar) {
            return ((C14301) create(l4, eVar)).invokeSuspend(E.f5463a);
        }
    }

    /* JADX INFO: renamed from: io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$getPrefs$1, reason: invalid class name and case insensitive filesystem */
    @InterfaceC0868f(c = "io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin", f = "SharedPreferencesPlugin.kt", l = {256, 258}, m = "getPrefs")
    public static final class C14311 extends AbstractC0866d {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        public C14311(Z2.e eVar) {
            super(eVar);
        }

        @Override // b3.AbstractC0863a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SharedPreferencesPlugin.this.getPrefs(null, this);
        }
    }

    /* JADX INFO: renamed from: io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$getString$1, reason: invalid class name and case insensitive filesystem */
    @InterfaceC0868f(c = "io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$getString$1", f = "SharedPreferencesPlugin.kt", l = {RCHTTPStatusCodes.CREATED}, m = "invokeSuspend")
    public static final class C14321 extends b3.l implements i3.o {
        final /* synthetic */ String $key;
        final /* synthetic */ F $value;
        Object L$0;
        int label;
        final /* synthetic */ SharedPreferencesPlugin this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C14321(String str, SharedPreferencesPlugin sharedPreferencesPlugin, F f4, Z2.e eVar) {
            super(2, eVar);
            this.$key = str;
            this.this$0 = sharedPreferencesPlugin;
            this.$value = f4;
        }

        @Override // b3.AbstractC0863a
        public final Z2.e create(Object obj, Z2.e eVar) {
            return new C14321(this.$key, this.this$0, this.$value, eVar);
        }

        @Override // b3.AbstractC0863a
        public final Object invokeSuspend(Object obj) throws Throwable {
            F f4;
            Object objE = AbstractC0787c.e();
            int i4 = this.label;
            if (i4 == 0) {
                W2.q.b(obj);
                final f.a aVarG = V.i.g(this.$key);
                Context context = this.this$0.context;
                if (context == null) {
                    kotlin.jvm.internal.r.t("context");
                    context = null;
                }
                final w3.d data = SharedPreferencesPluginKt.getSharedPreferencesDataStore(context).getData();
                w3.d dVar = new w3.d() { // from class: io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$getString$1$invokeSuspend$$inlined$map$1

                    /* JADX INFO: renamed from: io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$getString$1$invokeSuspend$$inlined$map$1$2, reason: invalid class name */
                    public static final class AnonymousClass2<T> implements w3.e {
                        final /* synthetic */ f.a $preferencesKey$inlined;
                        final /* synthetic */ w3.e $this_unsafeFlow;

                        /* JADX INFO: renamed from: io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$getString$1$invokeSuspend$$inlined$map$1$2$1, reason: invalid class name */
                        @InterfaceC0868f(c = "io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$getString$1$invokeSuspend$$inlined$map$1$2", f = "SharedPreferencesPlugin.kt", l = {223}, m = "emit")
                        public static final class AnonymousClass1 extends AbstractC0866d {
                            Object L$0;
                            int label;
                            /* synthetic */ Object result;

                            public AnonymousClass1(Z2.e eVar) {
                                super(eVar);
                            }

                            @Override // b3.AbstractC0863a
                            public final Object invokeSuspend(Object obj) {
                                this.result = obj;
                                this.label |= Integer.MIN_VALUE;
                                return AnonymousClass2.this.emit(null, this);
                            }
                        }

                        public AnonymousClass2(w3.e eVar, f.a aVar) {
                            this.$this_unsafeFlow = eVar;
                            this.$preferencesKey$inlined = aVar;
                        }

                        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                        @Override // w3.e
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                            To view partially-correct add '--show-bad-code' argument
                        */
                        public final java.lang.Object emit(java.lang.Object r5, Z2.e r6) throws java.lang.Throwable {
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
                                java.lang.Object r1 = a3.AbstractC0787c.e()
                                int r2 = r0.label
                                r3 = 1
                                if (r2 == 0) goto L31
                                if (r2 != r3) goto L29
                                W2.q.b(r6)
                                goto L47
                            L29:
                                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                                java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                                r5.<init>(r6)
                                throw r5
                            L31:
                                W2.q.b(r6)
                                w3.e r6 = r4.$this_unsafeFlow
                                V.f r5 = (V.f) r5
                                V.f$a r2 = r4.$preferencesKey$inlined
                                java.lang.Object r5 = r5.b(r2)
                                r0.label = r3
                                java.lang.Object r5 = r6.emit(r5, r0)
                                if (r5 != r1) goto L47
                                return r1
                            L47:
                                W2.E r5 = W2.E.f5463a
                                return r5
                            */
                            throw new UnsupportedOperationException("Method not decompiled: io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$getString$1$invokeSuspend$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, Z2.e):java.lang.Object");
                        }
                    }

                    @Override // w3.d
                    public Object collect(w3.e eVar, Z2.e eVar2) {
                        Object objCollect = data.collect(new AnonymousClass2(eVar, aVarG), eVar2);
                        return objCollect == AbstractC0787c.e() ? objCollect : E.f5463a;
                    }
                };
                F f5 = this.$value;
                this.L$0 = f5;
                this.label = 1;
                Object objL = w3.f.l(dVar, this);
                if (objL == objE) {
                    return objE;
                }
                f4 = f5;
                obj = objL;
            } else {
                if (i4 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                f4 = (F) this.L$0;
                W2.q.b(obj);
            }
            f4.f13410a = obj;
            return E.f5463a;
        }

        @Override // i3.o
        public final Object invoke(L l4, Z2.e eVar) {
            return ((C14321) create(l4, eVar)).invokeSuspend(E.f5463a);
        }
    }

    /* JADX INFO: renamed from: io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$setBool$1, reason: invalid class name and case insensitive filesystem */
    @InterfaceC0868f(c = "io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$setBool$1", f = "SharedPreferencesPlugin.kt", l = {81}, m = "invokeSuspend")
    public static final class C14331 extends b3.l implements i3.o {
        final /* synthetic */ String $key;
        final /* synthetic */ boolean $value;
        int label;
        final /* synthetic */ SharedPreferencesPlugin this$0;

        /* JADX INFO: renamed from: io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$setBool$1$1, reason: invalid class name and collision with other inner class name */
        @InterfaceC0868f(c = "io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$setBool$1$1", f = "SharedPreferencesPlugin.kt", l = {}, m = "invokeSuspend")
        public static final class C02041 extends b3.l implements i3.o {
            final /* synthetic */ f.a $boolKey;
            final /* synthetic */ boolean $value;
            /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C02041(f.a aVar, boolean z4, Z2.e eVar) {
                super(2, eVar);
                this.$boolKey = aVar;
                this.$value = z4;
            }

            @Override // b3.AbstractC0863a
            public final Z2.e create(Object obj, Z2.e eVar) {
                C02041 c02041 = new C02041(this.$boolKey, this.$value, eVar);
                c02041.L$0 = obj;
                return c02041;
            }

            @Override // i3.o
            public final Object invoke(V.c cVar, Z2.e eVar) {
                return ((C02041) create(cVar, eVar)).invokeSuspend(E.f5463a);
            }

            @Override // b3.AbstractC0863a
            public final Object invokeSuspend(Object obj) throws Throwable {
                AbstractC0787c.e();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                W2.q.b(obj);
                ((V.c) this.L$0).j(this.$boolKey, AbstractC0864b.a(this.$value));
                return E.f5463a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C14331(String str, SharedPreferencesPlugin sharedPreferencesPlugin, boolean z4, Z2.e eVar) {
            super(2, eVar);
            this.$key = str;
            this.this$0 = sharedPreferencesPlugin;
            this.$value = z4;
        }

        @Override // b3.AbstractC0863a
        public final Z2.e create(Object obj, Z2.e eVar) {
            return new C14331(this.$key, this.this$0, this.$value, eVar);
        }

        @Override // b3.AbstractC0863a
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objE = AbstractC0787c.e();
            int i4 = this.label;
            if (i4 == 0) {
                W2.q.b(obj);
                f.a aVarA = V.i.a(this.$key);
                Context context = this.this$0.context;
                if (context == null) {
                    kotlin.jvm.internal.r.t("context");
                    context = null;
                }
                InterfaceC0523i sharedPreferencesDataStore = SharedPreferencesPluginKt.getSharedPreferencesDataStore(context);
                C02041 c02041 = new C02041(aVarA, this.$value, null);
                this.label = 1;
                if (V.j.a(sharedPreferencesDataStore, c02041, this) == objE) {
                    return objE;
                }
            } else {
                if (i4 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                W2.q.b(obj);
            }
            return E.f5463a;
        }

        @Override // i3.o
        public final Object invoke(L l4, Z2.e eVar) {
            return ((C14331) create(l4, eVar)).invokeSuspend(E.f5463a);
        }
    }

    /* JADX INFO: renamed from: io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$setDeprecatedStringList$1, reason: invalid class name and case insensitive filesystem */
    @InterfaceC0868f(c = "io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$setDeprecatedStringList$1", f = "SharedPreferencesPlugin.kt", l = {UserMetadata.MAX_ROLLOUT_ASSIGNMENTS}, m = "invokeSuspend")
    public static final class C14341 extends b3.l implements i3.o {
        final /* synthetic */ String $key;
        final /* synthetic */ String $valueString;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C14341(String str, String str2, Z2.e eVar) {
            super(2, eVar);
            this.$key = str;
            this.$valueString = str2;
        }

        @Override // b3.AbstractC0863a
        public final Z2.e create(Object obj, Z2.e eVar) {
            return SharedPreferencesPlugin.this.new C14341(this.$key, this.$valueString, eVar);
        }

        @Override // b3.AbstractC0863a
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objE = AbstractC0787c.e();
            int i4 = this.label;
            if (i4 == 0) {
                W2.q.b(obj);
                SharedPreferencesPlugin sharedPreferencesPlugin = SharedPreferencesPlugin.this;
                String str = this.$key;
                String str2 = this.$valueString;
                this.label = 1;
                if (sharedPreferencesPlugin.dataStoreSetString(str, str2, this) == objE) {
                    return objE;
                }
            } else {
                if (i4 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                W2.q.b(obj);
            }
            return E.f5463a;
        }

        @Override // i3.o
        public final Object invoke(L l4, Z2.e eVar) {
            return ((C14341) create(l4, eVar)).invokeSuspend(E.f5463a);
        }
    }

    /* JADX INFO: renamed from: io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$setDouble$1, reason: invalid class name and case insensitive filesystem */
    @InterfaceC0868f(c = "io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$setDouble$1", f = "SharedPreferencesPlugin.kt", l = {107}, m = "invokeSuspend")
    public static final class C14351 extends b3.l implements i3.o {
        final /* synthetic */ String $key;
        final /* synthetic */ double $value;
        int label;
        final /* synthetic */ SharedPreferencesPlugin this$0;

        /* JADX INFO: renamed from: io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$setDouble$1$1, reason: invalid class name and collision with other inner class name */
        @InterfaceC0868f(c = "io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$setDouble$1$1", f = "SharedPreferencesPlugin.kt", l = {}, m = "invokeSuspend")
        public static final class C02051 extends b3.l implements i3.o {
            final /* synthetic */ f.a $doubleKey;
            final /* synthetic */ double $value;
            /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C02051(f.a aVar, double d4, Z2.e eVar) {
                super(2, eVar);
                this.$doubleKey = aVar;
                this.$value = d4;
            }

            @Override // b3.AbstractC0863a
            public final Z2.e create(Object obj, Z2.e eVar) {
                C02051 c02051 = new C02051(this.$doubleKey, this.$value, eVar);
                c02051.L$0 = obj;
                return c02051;
            }

            @Override // i3.o
            public final Object invoke(V.c cVar, Z2.e eVar) {
                return ((C02051) create(cVar, eVar)).invokeSuspend(E.f5463a);
            }

            @Override // b3.AbstractC0863a
            public final Object invokeSuspend(Object obj) throws Throwable {
                AbstractC0787c.e();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                W2.q.b(obj);
                ((V.c) this.L$0).j(this.$doubleKey, AbstractC0864b.b(this.$value));
                return E.f5463a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C14351(String str, SharedPreferencesPlugin sharedPreferencesPlugin, double d4, Z2.e eVar) {
            super(2, eVar);
            this.$key = str;
            this.this$0 = sharedPreferencesPlugin;
            this.$value = d4;
        }

        @Override // b3.AbstractC0863a
        public final Z2.e create(Object obj, Z2.e eVar) {
            return new C14351(this.$key, this.this$0, this.$value, eVar);
        }

        @Override // b3.AbstractC0863a
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objE = AbstractC0787c.e();
            int i4 = this.label;
            if (i4 == 0) {
                W2.q.b(obj);
                f.a aVarC = V.i.c(this.$key);
                Context context = this.this$0.context;
                if (context == null) {
                    kotlin.jvm.internal.r.t("context");
                    context = null;
                }
                InterfaceC0523i sharedPreferencesDataStore = SharedPreferencesPluginKt.getSharedPreferencesDataStore(context);
                C02051 c02051 = new C02051(aVarC, this.$value, null);
                this.label = 1;
                if (V.j.a(sharedPreferencesDataStore, c02051, this) == objE) {
                    return objE;
                }
            } else {
                if (i4 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                W2.q.b(obj);
            }
            return E.f5463a;
        }

        @Override // i3.o
        public final Object invoke(L l4, Z2.e eVar) {
            return ((C14351) create(l4, eVar)).invokeSuspend(E.f5463a);
        }
    }

    /* JADX INFO: renamed from: io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$setEncodedStringList$1, reason: invalid class name and case insensitive filesystem */
    @InterfaceC0868f(c = "io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$setEncodedStringList$1", f = "SharedPreferencesPlugin.kt", l = {117}, m = "invokeSuspend")
    public static final class C14361 extends b3.l implements i3.o {
        final /* synthetic */ String $key;
        final /* synthetic */ String $value;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C14361(String str, String str2, Z2.e eVar) {
            super(2, eVar);
            this.$key = str;
            this.$value = str2;
        }

        @Override // b3.AbstractC0863a
        public final Z2.e create(Object obj, Z2.e eVar) {
            return SharedPreferencesPlugin.this.new C14361(this.$key, this.$value, eVar);
        }

        @Override // b3.AbstractC0863a
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objE = AbstractC0787c.e();
            int i4 = this.label;
            if (i4 == 0) {
                W2.q.b(obj);
                SharedPreferencesPlugin sharedPreferencesPlugin = SharedPreferencesPlugin.this;
                String str = this.$key;
                String str2 = this.$value;
                this.label = 1;
                if (sharedPreferencesPlugin.dataStoreSetString(str, str2, this) == objE) {
                    return objE;
                }
            } else {
                if (i4 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                W2.q.b(obj);
            }
            return E.f5463a;
        }

        @Override // i3.o
        public final Object invoke(L l4, Z2.e eVar) {
            return ((C14361) create(l4, eVar)).invokeSuspend(E.f5463a);
        }
    }

    /* JADX INFO: renamed from: io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$setInt$1, reason: invalid class name and case insensitive filesystem */
    @InterfaceC0868f(c = "io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$setInt$1", f = "SharedPreferencesPlugin.kt", l = {99}, m = "invokeSuspend")
    public static final class C14371 extends b3.l implements i3.o {
        final /* synthetic */ String $key;
        final /* synthetic */ long $value;
        int label;
        final /* synthetic */ SharedPreferencesPlugin this$0;

        /* JADX INFO: renamed from: io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$setInt$1$1, reason: invalid class name and collision with other inner class name */
        @InterfaceC0868f(c = "io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$setInt$1$1", f = "SharedPreferencesPlugin.kt", l = {}, m = "invokeSuspend")
        public static final class C02061 extends b3.l implements i3.o {
            final /* synthetic */ f.a $intKey;
            final /* synthetic */ long $value;
            /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C02061(f.a aVar, long j4, Z2.e eVar) {
                super(2, eVar);
                this.$intKey = aVar;
                this.$value = j4;
            }

            @Override // b3.AbstractC0863a
            public final Z2.e create(Object obj, Z2.e eVar) {
                C02061 c02061 = new C02061(this.$intKey, this.$value, eVar);
                c02061.L$0 = obj;
                return c02061;
            }

            @Override // i3.o
            public final Object invoke(V.c cVar, Z2.e eVar) {
                return ((C02061) create(cVar, eVar)).invokeSuspend(E.f5463a);
            }

            @Override // b3.AbstractC0863a
            public final Object invokeSuspend(Object obj) throws Throwable {
                AbstractC0787c.e();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                W2.q.b(obj);
                ((V.c) this.L$0).j(this.$intKey, AbstractC0864b.d(this.$value));
                return E.f5463a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C14371(String str, SharedPreferencesPlugin sharedPreferencesPlugin, long j4, Z2.e eVar) {
            super(2, eVar);
            this.$key = str;
            this.this$0 = sharedPreferencesPlugin;
            this.$value = j4;
        }

        @Override // b3.AbstractC0863a
        public final Z2.e create(Object obj, Z2.e eVar) {
            return new C14371(this.$key, this.this$0, this.$value, eVar);
        }

        @Override // b3.AbstractC0863a
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objE = AbstractC0787c.e();
            int i4 = this.label;
            if (i4 == 0) {
                W2.q.b(obj);
                f.a aVarF = V.i.f(this.$key);
                Context context = this.this$0.context;
                if (context == null) {
                    kotlin.jvm.internal.r.t("context");
                    context = null;
                }
                InterfaceC0523i sharedPreferencesDataStore = SharedPreferencesPluginKt.getSharedPreferencesDataStore(context);
                C02061 c02061 = new C02061(aVarF, this.$value, null);
                this.label = 1;
                if (V.j.a(sharedPreferencesDataStore, c02061, this) == objE) {
                    return objE;
                }
            } else {
                if (i4 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                W2.q.b(obj);
            }
            return E.f5463a;
        }

        @Override // i3.o
        public final Object invoke(L l4, Z2.e eVar) {
            return ((C14371) create(l4, eVar)).invokeSuspend(E.f5463a);
        }
    }

    /* JADX INFO: renamed from: io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$setString$1, reason: invalid class name and case insensitive filesystem */
    @InterfaceC0868f(c = "io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$setString$1", f = "SharedPreferencesPlugin.kt", l = {87}, m = "invokeSuspend")
    public static final class C14381 extends b3.l implements i3.o {
        final /* synthetic */ String $key;
        final /* synthetic */ String $value;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C14381(String str, String str2, Z2.e eVar) {
            super(2, eVar);
            this.$key = str;
            this.$value = str2;
        }

        @Override // b3.AbstractC0863a
        public final Z2.e create(Object obj, Z2.e eVar) {
            return SharedPreferencesPlugin.this.new C14381(this.$key, this.$value, eVar);
        }

        @Override // b3.AbstractC0863a
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objE = AbstractC0787c.e();
            int i4 = this.label;
            if (i4 == 0) {
                W2.q.b(obj);
                SharedPreferencesPlugin sharedPreferencesPlugin = SharedPreferencesPlugin.this;
                String str = this.$key;
                String str2 = this.$value;
                this.label = 1;
                if (sharedPreferencesPlugin.dataStoreSetString(str, str2, this) == objE) {
                    return objE;
                }
            } else {
                if (i4 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                W2.q.b(obj);
            }
            return E.f5463a;
        }

        @Override // i3.o
        public final Object invoke(L l4, Z2.e eVar) {
            return ((C14381) create(l4, eVar)).invokeSuspend(E.f5463a);
        }
    }

    public SharedPreferencesPlugin() {
        this.listEncoder = new ListEncoder();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object dataStoreSetString(String str, String str2, Z2.e eVar) {
        f.a aVarG = V.i.g(str);
        Context context = this.context;
        if (context == null) {
            kotlin.jvm.internal.r.t("context");
            context = null;
        }
        Object objA = V.j.a(SharedPreferencesPluginKt.getSharedPreferencesDataStore(context), new AnonymousClass2(aVarG, str2, null), eVar);
        return objA == AbstractC0787c.e() ? objA : E.f5463a;
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
    public final java.lang.Object getPrefs(java.util.List<java.lang.String> r9, Z2.e r10) throws java.lang.Throwable {
        /*
            r8 = this;
            boolean r0 = r10 instanceof io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin.C14311
            if (r0 == 0) goto L13
            r0 = r10
            io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$getPrefs$1 r0 = (io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin.C14311) r0
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
            java.lang.Object r1 = a3.AbstractC0787c.e()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L59
            if (r2 == r4) goto L49
            if (r2 != r3) goto L41
            java.lang.Object r9 = r0.L$4
            V.f$a r9 = (V.f.a) r9
            java.lang.Object r2 = r0.L$3
            java.util.Iterator r2 = (java.util.Iterator) r2
            java.lang.Object r4 = r0.L$2
            java.util.Map r4 = (java.util.Map) r4
            java.lang.Object r5 = r0.L$1
            java.util.Set r5 = (java.util.Set) r5
            java.lang.Object r6 = r0.L$0
            io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin r6 = (io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin) r6
            W2.q.b(r10)
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
            W2.q.b(r10)
            goto L7b
        L59:
            W2.q.b(r10)
            if (r9 == 0) goto L64
            java.util.Set r9 = X2.x.l0(r9)
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
            V.f$a r9 = (V.f.a) r9
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
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin.getPrefs(java.util.List, Z2.e):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object getValueByKey(final f.a aVar, Z2.e eVar) {
        Context context = this.context;
        if (context == null) {
            kotlin.jvm.internal.r.t("context");
            context = null;
        }
        final w3.d data = SharedPreferencesPluginKt.getSharedPreferencesDataStore(context).getData();
        return w3.f.l(new w3.d() { // from class: io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$getValueByKey$$inlined$map$1

            /* JADX INFO: renamed from: io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$getValueByKey$$inlined$map$1$2, reason: invalid class name */
            public static final class AnonymousClass2<T> implements w3.e {
                final /* synthetic */ f.a $key$inlined;
                final /* synthetic */ w3.e $this_unsafeFlow;

                /* JADX INFO: renamed from: io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$getValueByKey$$inlined$map$1$2$1, reason: invalid class name */
                @InterfaceC0868f(c = "io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$getValueByKey$$inlined$map$1$2", f = "SharedPreferencesPlugin.kt", l = {223}, m = "emit")
                public static final class AnonymousClass1 extends AbstractC0866d {
                    Object L$0;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Z2.e eVar) {
                        super(eVar);
                    }

                    @Override // b3.AbstractC0863a
                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(w3.e eVar, f.a aVar) {
                    this.$this_unsafeFlow = eVar;
                    this.$key$inlined = aVar;
                }

                /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                @Override // w3.e
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object emit(java.lang.Object r5, Z2.e r6) throws java.lang.Throwable {
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
                        java.lang.Object r1 = a3.AbstractC0787c.e()
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        W2.q.b(r6)
                        goto L47
                    L29:
                        java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                        java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                        r5.<init>(r6)
                        throw r5
                    L31:
                        W2.q.b(r6)
                        w3.e r6 = r4.$this_unsafeFlow
                        V.f r5 = (V.f) r5
                        V.f$a r2 = r4.$key$inlined
                        java.lang.Object r5 = r5.b(r2)
                        r0.label = r3
                        java.lang.Object r5 = r6.emit(r5, r0)
                        if (r5 != r1) goto L47
                        return r1
                    L47:
                        W2.E r5 = W2.E.f5463a
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$getValueByKey$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, Z2.e):java.lang.Object");
                }
            }

            @Override // w3.d
            public Object collect(w3.e eVar2, Z2.e eVar3) {
                Object objCollect = data.collect(new AnonymousClass2(eVar2, aVar), eVar3);
                return objCollect == AbstractC0787c.e() ? objCollect : E.f5463a;
            }
        }, eVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object readAllKeys(Z2.e eVar) {
        Context context = this.context;
        if (context == null) {
            kotlin.jvm.internal.r.t("context");
            context = null;
        }
        final w3.d data = SharedPreferencesPluginKt.getSharedPreferencesDataStore(context).getData();
        return w3.f.l(new w3.d() { // from class: io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$readAllKeys$$inlined$map$1

            /* JADX INFO: renamed from: io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$readAllKeys$$inlined$map$1$2, reason: invalid class name */
            public static final class AnonymousClass2<T> implements w3.e {
                final /* synthetic */ w3.e $this_unsafeFlow;

                /* JADX INFO: renamed from: io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$readAllKeys$$inlined$map$1$2$1, reason: invalid class name */
                @InterfaceC0868f(c = "io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$readAllKeys$$inlined$map$1$2", f = "SharedPreferencesPlugin.kt", l = {223}, m = "emit")
                public static final class AnonymousClass1 extends AbstractC0866d {
                    Object L$0;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Z2.e eVar) {
                        super(eVar);
                    }

                    @Override // b3.AbstractC0863a
                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(w3.e eVar) {
                    this.$this_unsafeFlow = eVar;
                }

                /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                @Override // w3.e
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object emit(java.lang.Object r5, Z2.e r6) throws java.lang.Throwable {
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
                        java.lang.Object r1 = a3.AbstractC0787c.e()
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        W2.q.b(r6)
                        goto L49
                    L29:
                        java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                        java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                        r5.<init>(r6)
                        throw r5
                    L31:
                        W2.q.b(r6)
                        w3.e r6 = r4.$this_unsafeFlow
                        V.f r5 = (V.f) r5
                        java.util.Map r5 = r5.a()
                        java.util.Set r5 = r5.keySet()
                        r0.label = r3
                        java.lang.Object r5 = r6.emit(r5, r0)
                        if (r5 != r1) goto L49
                        return r1
                    L49:
                        W2.E r5 = W2.E.f5463a
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$readAllKeys$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, Z2.e):java.lang.Object");
                }
            }

            @Override // w3.d
            public Object collect(w3.e eVar2, Z2.e eVar3) {
                Object objCollect = data.collect(new AnonymousClass2(eVar2), eVar3);
                return objCollect == AbstractC0787c.e() ? objCollect : E.f5463a;
            }
        }, eVar);
    }

    private final void setUp(BinaryMessenger binaryMessenger, Context context) {
        this.context = context;
        try {
            SharedPreferencesAsyncApi.Companion.setUp(binaryMessenger, this, "data_store");
            this.backend = new SharedPreferencesBackend(binaryMessenger, context, this.listEncoder);
        } catch (Exception e4) {
            Log.e(SharedPreferencesPluginKt.TAG, "Received exception while setting up SharedPreferencesPlugin", e4);
        }
    }

    @Override // io.flutter.plugins.sharedpreferences.SharedPreferencesAsyncApi
    public void clear(List<String> list, SharedPreferencesPigeonOptions options) {
        kotlin.jvm.internal.r.f(options, "options");
        AbstractC1820j.b(null, new AnonymousClass1(list, null), 1, null);
    }

    @Override // io.flutter.plugins.sharedpreferences.SharedPreferencesAsyncApi
    public Map<String, Object> getAll(List<String> list, SharedPreferencesPigeonOptions options) {
        kotlin.jvm.internal.r.f(options, "options");
        return (Map) AbstractC1820j.b(null, new C14271(list, null), 1, null);
    }

    @Override // io.flutter.plugins.sharedpreferences.SharedPreferencesAsyncApi
    public Boolean getBool(String key, SharedPreferencesPigeonOptions options) {
        kotlin.jvm.internal.r.f(key, "key");
        kotlin.jvm.internal.r.f(options, "options");
        F f4 = new F();
        AbstractC1820j.b(null, new C14281(key, this, f4, null), 1, null);
        return (Boolean) f4.f13410a;
    }

    @Override // io.flutter.plugins.sharedpreferences.SharedPreferencesAsyncApi
    public Double getDouble(String key, SharedPreferencesPigeonOptions options) {
        kotlin.jvm.internal.r.f(key, "key");
        kotlin.jvm.internal.r.f(options, "options");
        F f4 = new F();
        AbstractC1820j.b(null, new C14291(key, this, f4, null), 1, null);
        return (Double) f4.f13410a;
    }

    @Override // io.flutter.plugins.sharedpreferences.SharedPreferencesAsyncApi
    public Long getInt(String key, SharedPreferencesPigeonOptions options) {
        kotlin.jvm.internal.r.f(key, "key");
        kotlin.jvm.internal.r.f(options, "options");
        F f4 = new F();
        AbstractC1820j.b(null, new C14301(key, this, f4, null), 1, null);
        return (Long) f4.f13410a;
    }

    @Override // io.flutter.plugins.sharedpreferences.SharedPreferencesAsyncApi
    public List<String> getKeys(List<String> list, SharedPreferencesPigeonOptions options) {
        kotlin.jvm.internal.r.f(options, "options");
        return X2.x.g0(((Map) AbstractC1820j.b(null, new SharedPreferencesPlugin$getKeys$prefs$1(this, list, null), 1, null)).keySet());
    }

    @Override // io.flutter.plugins.sharedpreferences.SharedPreferencesAsyncApi
    public List<String> getPlatformEncodedStringList(String key, SharedPreferencesPigeonOptions options) {
        List list;
        kotlin.jvm.internal.r.f(key, "key");
        kotlin.jvm.internal.r.f(options, "options");
        String string = getString(key, options);
        ArrayList arrayList = null;
        if (string != null && !r3.x.C(string, SharedPreferencesPluginKt.JSON_LIST_PREFIX, false, 2, null) && r3.x.C(string, SharedPreferencesPluginKt.LIST_PREFIX, false, 2, null) && (list = (List) SharedPreferencesPluginKt.transformPref(string, this.listEncoder)) != null) {
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
        kotlin.jvm.internal.r.f(key, "key");
        kotlin.jvm.internal.r.f(options, "options");
        F f4 = new F();
        AbstractC1820j.b(null, new C14321(key, this, f4, null), 1, null);
        return (String) f4.f13410a;
    }

    @Override // io.flutter.plugins.sharedpreferences.SharedPreferencesAsyncApi
    public StringListResult getStringList(String key, SharedPreferencesPigeonOptions options) {
        kotlin.jvm.internal.r.f(key, "key");
        kotlin.jvm.internal.r.f(options, "options");
        String string = getString(key, options);
        if (string != null) {
            return r3.x.C(string, SharedPreferencesPluginKt.JSON_LIST_PREFIX, false, 2, null) ? new StringListResult(string, StringListLookupResultType.JSON_ENCODED) : r3.x.C(string, SharedPreferencesPluginKt.LIST_PREFIX, false, 2, null) ? new StringListResult(null, StringListLookupResultType.PLATFORM_ENCODED) : new StringListResult(null, StringListLookupResultType.UNEXPECTED_STRING);
        }
        return null;
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding binding) {
        kotlin.jvm.internal.r.f(binding, "binding");
        BinaryMessenger binaryMessenger = binding.getBinaryMessenger();
        kotlin.jvm.internal.r.e(binaryMessenger, "getBinaryMessenger(...)");
        Context applicationContext = binding.getApplicationContext();
        kotlin.jvm.internal.r.e(applicationContext, "getApplicationContext(...)");
        setUp(binaryMessenger, applicationContext);
        new LegacySharedPreferencesPlugin().onAttachedToEngine(binding);
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding binding) {
        kotlin.jvm.internal.r.f(binding, "binding");
        SharedPreferencesAsyncApi.Companion companion = SharedPreferencesAsyncApi.Companion;
        BinaryMessenger binaryMessenger = binding.getBinaryMessenger();
        kotlin.jvm.internal.r.e(binaryMessenger, "getBinaryMessenger(...)");
        companion.setUp(binaryMessenger, null, "data_store");
        SharedPreferencesBackend sharedPreferencesBackend = this.backend;
        if (sharedPreferencesBackend != null) {
            sharedPreferencesBackend.tearDown();
        }
        this.backend = null;
    }

    @Override // io.flutter.plugins.sharedpreferences.SharedPreferencesAsyncApi
    public void setBool(String key, boolean z4, SharedPreferencesPigeonOptions options) {
        kotlin.jvm.internal.r.f(key, "key");
        kotlin.jvm.internal.r.f(options, "options");
        AbstractC1820j.b(null, new C14331(key, this, z4, null), 1, null);
    }

    @Override // io.flutter.plugins.sharedpreferences.SharedPreferencesAsyncApi
    public void setDeprecatedStringList(String key, List<String> value, SharedPreferencesPigeonOptions options) {
        kotlin.jvm.internal.r.f(key, "key");
        kotlin.jvm.internal.r.f(value, "value");
        kotlin.jvm.internal.r.f(options, "options");
        AbstractC1820j.b(null, new C14341(key, SharedPreferencesPluginKt.LIST_PREFIX + this.listEncoder.encode(value), null), 1, null);
    }

    @Override // io.flutter.plugins.sharedpreferences.SharedPreferencesAsyncApi
    public void setDouble(String key, double d4, SharedPreferencesPigeonOptions options) {
        kotlin.jvm.internal.r.f(key, "key");
        kotlin.jvm.internal.r.f(options, "options");
        AbstractC1820j.b(null, new C14351(key, this, d4, null), 1, null);
    }

    @Override // io.flutter.plugins.sharedpreferences.SharedPreferencesAsyncApi
    public void setEncodedStringList(String key, String value, SharedPreferencesPigeonOptions options) {
        kotlin.jvm.internal.r.f(key, "key");
        kotlin.jvm.internal.r.f(value, "value");
        kotlin.jvm.internal.r.f(options, "options");
        AbstractC1820j.b(null, new C14361(key, value, null), 1, null);
    }

    @Override // io.flutter.plugins.sharedpreferences.SharedPreferencesAsyncApi
    public void setInt(String key, long j4, SharedPreferencesPigeonOptions options) {
        kotlin.jvm.internal.r.f(key, "key");
        kotlin.jvm.internal.r.f(options, "options");
        AbstractC1820j.b(null, new C14371(key, this, j4, null), 1, null);
    }

    @Override // io.flutter.plugins.sharedpreferences.SharedPreferencesAsyncApi
    public void setString(String key, String value, SharedPreferencesPigeonOptions options) {
        kotlin.jvm.internal.r.f(key, "key");
        kotlin.jvm.internal.r.f(value, "value");
        kotlin.jvm.internal.r.f(options, "options");
        AbstractC1820j.b(null, new C14381(key, value, null), 1, null);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SharedPreferencesPlugin(SharedPreferencesListEncoder listEncoder) {
        this();
        kotlin.jvm.internal.r.f(listEncoder, "listEncoder");
        this.listEncoder = listEncoder;
    }
}
