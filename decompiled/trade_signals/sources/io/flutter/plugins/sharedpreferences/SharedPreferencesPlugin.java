package io.flutter.plugins.sharedpreferences;

import V6.A;
import Y6.AbstractC1007h;
import Y6.L;
import android.content.Context;
import android.util.Log;
import b0.InterfaceC1178i;
import com.revenuecat.purchases.common.networking.RCHTTPStatusCodes;
import g0.AbstractC1776f;
import g0.AbstractC1778h;
import g0.AbstractC1779i;
import g0.C1773c;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugins.sharedpreferences.SharedPreferencesAsyncApi;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.AbstractC2304t;
import kotlin.jvm.internal.N;
import o5.AbstractC2491s;
import o5.C2470H;
import p5.z;
import s5.InterfaceC2707e;
import t5.AbstractC2751c;
import u5.AbstractC2775b;
import u5.AbstractC2777d;
import u5.AbstractC2785l;
import u5.InterfaceC2779f;

/* JADX INFO: loaded from: classes.dex */
public final class SharedPreferencesPlugin implements FlutterPlugin, SharedPreferencesAsyncApi {
    private SharedPreferencesBackend backend;
    private Context context;
    private SharedPreferencesListEncoder listEncoder;

    /* JADX INFO: renamed from: io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$clear$1, reason: invalid class name */
    @InterfaceC2779f(c = "io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$clear$1", f = "SharedPreferencesPlugin.kt", l = {134}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends AbstractC2785l implements B5.o {
        final /* synthetic */ List<String> $allowList;
        int label;

        /* JADX INFO: renamed from: io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$clear$1$1, reason: invalid class name and collision with other inner class name */
        @InterfaceC2779f(c = "io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$clear$1$1", f = "SharedPreferencesPlugin.kt", l = {}, m = "invokeSuspend")
        public static final class C03201 extends AbstractC2785l implements B5.o {
            final /* synthetic */ List<String> $allowList;
            /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C03201(List<String> list, InterfaceC2707e interfaceC2707e) {
                super(2, interfaceC2707e);
                this.$allowList = list;
            }

            @Override // u5.AbstractC2774a
            public final InterfaceC2707e create(Object obj, InterfaceC2707e interfaceC2707e) {
                C03201 c03201 = new C03201(this.$allowList, interfaceC2707e);
                c03201.L$0 = obj;
                return c03201;
            }

            @Override // B5.o
            public final Object invoke(C1773c c1773c, InterfaceC2707e interfaceC2707e) {
                return ((C03201) create(c1773c, interfaceC2707e)).invokeSuspend(C2470H.f21956a);
            }

            @Override // u5.AbstractC2774a
            public final Object invokeSuspend(Object obj) throws Throwable {
                AbstractC2751c.f();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC2491s.b(obj);
                C1773c c1773c = (C1773c) this.L$0;
                List<String> list = this.$allowList;
                if (list != null) {
                    Iterator<T> it = list.iterator();
                    while (it.hasNext()) {
                        c1773c.i(AbstractC1778h.a((String) it.next()));
                    }
                } else {
                    c1773c.f();
                }
                return C2470H.f21956a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(List<String> list, InterfaceC2707e interfaceC2707e) {
            super(2, interfaceC2707e);
            this.$allowList = list;
        }

        @Override // u5.AbstractC2774a
        public final InterfaceC2707e create(Object obj, InterfaceC2707e interfaceC2707e) {
            return SharedPreferencesPlugin.this.new AnonymousClass1(this.$allowList, interfaceC2707e);
        }

        @Override // B5.o
        public final Object invoke(L l8, InterfaceC2707e interfaceC2707e) {
            return ((AnonymousClass1) create(l8, interfaceC2707e)).invokeSuspend(C2470H.f21956a);
        }

        @Override // u5.AbstractC2774a
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = AbstractC2751c.f();
            int i8 = this.label;
            if (i8 == 0) {
                AbstractC2491s.b(obj);
                Context context = SharedPreferencesPlugin.this.context;
                if (context == null) {
                    AbstractC2304t.s("context");
                    context = null;
                }
                InterfaceC1178i sharedPreferencesDataStore = SharedPreferencesPluginKt.getSharedPreferencesDataStore(context);
                C03201 c03201 = new C03201(this.$allowList, null);
                this.label = 1;
                obj = AbstractC1779i.a(sharedPreferencesDataStore, c03201, this);
                if (obj == objF) {
                    return objF;
                }
            } else {
                if (i8 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC2491s.b(obj);
            }
            return obj;
        }
    }

    /* JADX INFO: renamed from: io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$dataStoreSetString$2, reason: invalid class name */
    @InterfaceC2779f(c = "io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$dataStoreSetString$2", f = "SharedPreferencesPlugin.kt", l = {}, m = "invokeSuspend")
    public static final class AnonymousClass2 extends AbstractC2785l implements B5.o {
        final /* synthetic */ AbstractC1776f.a $stringKey;
        final /* synthetic */ String $value;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(AbstractC1776f.a aVar, String str, InterfaceC2707e interfaceC2707e) {
            super(2, interfaceC2707e);
            this.$stringKey = aVar;
            this.$value = str;
        }

        @Override // u5.AbstractC2774a
        public final InterfaceC2707e create(Object obj, InterfaceC2707e interfaceC2707e) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$stringKey, this.$value, interfaceC2707e);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // B5.o
        public final Object invoke(C1773c c1773c, InterfaceC2707e interfaceC2707e) {
            return ((AnonymousClass2) create(c1773c, interfaceC2707e)).invokeSuspend(C2470H.f21956a);
        }

        @Override // u5.AbstractC2774a
        public final Object invokeSuspend(Object obj) throws Throwable {
            AbstractC2751c.f();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC2491s.b(obj);
            ((C1773c) this.L$0).j(this.$stringKey, this.$value);
            return C2470H.f21956a;
        }
    }

    /* JADX INFO: renamed from: io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$getAll$1, reason: invalid class name and case insensitive filesystem */
    @InterfaceC2779f(c = "io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$getAll$1", f = "SharedPreferencesPlugin.kt", l = {150}, m = "invokeSuspend")
    public static final class C20421 extends AbstractC2785l implements B5.o {
        final /* synthetic */ List<String> $allowList;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C20421(List<String> list, InterfaceC2707e interfaceC2707e) {
            super(2, interfaceC2707e);
            this.$allowList = list;
        }

        @Override // u5.AbstractC2774a
        public final InterfaceC2707e create(Object obj, InterfaceC2707e interfaceC2707e) {
            return SharedPreferencesPlugin.this.new C20421(this.$allowList, interfaceC2707e);
        }

        @Override // B5.o
        public final Object invoke(L l8, InterfaceC2707e interfaceC2707e) {
            return ((C20421) create(l8, interfaceC2707e)).invokeSuspend(C2470H.f21956a);
        }

        @Override // u5.AbstractC2774a
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = AbstractC2751c.f();
            int i8 = this.label;
            if (i8 == 0) {
                AbstractC2491s.b(obj);
                SharedPreferencesPlugin sharedPreferencesPlugin = SharedPreferencesPlugin.this;
                List<String> list = this.$allowList;
                this.label = 1;
                obj = sharedPreferencesPlugin.getPrefs(list, this);
                if (obj == objF) {
                    return objF;
                }
            } else {
                if (i8 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC2491s.b(obj);
            }
            return obj;
        }
    }

    /* JADX INFO: renamed from: io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$getBool$1, reason: invalid class name and case insensitive filesystem */
    @InterfaceC2779f(c = "io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$getBool$1", f = "SharedPreferencesPlugin.kt", l = {174}, m = "invokeSuspend")
    public static final class C20431 extends AbstractC2785l implements B5.o {
        final /* synthetic */ String $key;
        final /* synthetic */ N $value;
        Object L$0;
        int label;
        final /* synthetic */ SharedPreferencesPlugin this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C20431(String str, SharedPreferencesPlugin sharedPreferencesPlugin, N n8, InterfaceC2707e interfaceC2707e) {
            super(2, interfaceC2707e);
            this.$key = str;
            this.this$0 = sharedPreferencesPlugin;
            this.$value = n8;
        }

        @Override // u5.AbstractC2774a
        public final InterfaceC2707e create(Object obj, InterfaceC2707e interfaceC2707e) {
            return new C20431(this.$key, this.this$0, this.$value, interfaceC2707e);
        }

        @Override // B5.o
        public final Object invoke(L l8, InterfaceC2707e interfaceC2707e) {
            return ((C20431) create(l8, interfaceC2707e)).invokeSuspend(C2470H.f21956a);
        }

        @Override // u5.AbstractC2774a
        public final Object invokeSuspend(Object obj) throws Throwable {
            N n8;
            Object objF = AbstractC2751c.f();
            int i8 = this.label;
            if (i8 == 0) {
                AbstractC2491s.b(obj);
                final AbstractC1776f.a aVarA = AbstractC1778h.a(this.$key);
                Context context = this.this$0.context;
                if (context == null) {
                    AbstractC2304t.s("context");
                    context = null;
                }
                final b7.d data = SharedPreferencesPluginKt.getSharedPreferencesDataStore(context).getData();
                b7.d dVar = new b7.d() { // from class: io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$getBool$1$invokeSuspend$$inlined$map$1

                    /* JADX INFO: renamed from: io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$getBool$1$invokeSuspend$$inlined$map$1$2, reason: invalid class name */
                    public static final class AnonymousClass2<T> implements b7.e {
                        final /* synthetic */ AbstractC1776f.a $preferencesKey$inlined;
                        final /* synthetic */ b7.e $this_unsafeFlow;

                        /* JADX INFO: renamed from: io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$getBool$1$invokeSuspend$$inlined$map$1$2$1, reason: invalid class name */
                        @InterfaceC2779f(c = "io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$getBool$1$invokeSuspend$$inlined$map$1$2", f = "SharedPreferencesPlugin.kt", l = {223}, m = "emit")
                        public static final class AnonymousClass1 extends AbstractC2777d {
                            Object L$0;
                            int label;
                            /* synthetic */ Object result;

                            public AnonymousClass1(InterfaceC2707e interfaceC2707e) {
                                super(interfaceC2707e);
                            }

                            @Override // u5.AbstractC2774a
                            public final Object invokeSuspend(Object obj) {
                                this.result = obj;
                                this.label |= Integer.MIN_VALUE;
                                return AnonymousClass2.this.emit(null, this);
                            }
                        }

                        public AnonymousClass2(b7.e eVar, AbstractC1776f.a aVar) {
                            this.$this_unsafeFlow = eVar;
                            this.$preferencesKey$inlined = aVar;
                        }

                        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                        @Override // b7.e
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                            To view partially-correct add '--show-bad-code' argument
                        */
                        public final java.lang.Object emit(java.lang.Object r5, s5.InterfaceC2707e r6) throws java.lang.Throwable {
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
                                java.lang.Object r1 = t5.AbstractC2751c.f()
                                int r2 = r0.label
                                r3 = 1
                                if (r2 == 0) goto L31
                                if (r2 != r3) goto L29
                                o5.AbstractC2491s.b(r6)
                                goto L47
                            L29:
                                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                                java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                                r5.<init>(r6)
                                throw r5
                            L31:
                                o5.AbstractC2491s.b(r6)
                                b7.e r6 = r4.$this_unsafeFlow
                                g0.f r5 = (g0.AbstractC1776f) r5
                                g0.f$a r2 = r4.$preferencesKey$inlined
                                java.lang.Object r5 = r5.b(r2)
                                r0.label = r3
                                java.lang.Object r5 = r6.emit(r5, r0)
                                if (r5 != r1) goto L47
                                return r1
                            L47:
                                o5.H r5 = o5.C2470H.f21956a
                                return r5
                            */
                            throw new UnsupportedOperationException("Method not decompiled: io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$getBool$1$invokeSuspend$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, s5.e):java.lang.Object");
                        }
                    }

                    @Override // b7.d
                    public Object collect(b7.e eVar, InterfaceC2707e interfaceC2707e) {
                        Object objCollect = data.collect(new AnonymousClass2(eVar, aVarA), interfaceC2707e);
                        return objCollect == AbstractC2751c.f() ? objCollect : C2470H.f21956a;
                    }
                };
                N n9 = this.$value;
                this.L$0 = n9;
                this.label = 1;
                Object objM = b7.f.m(dVar, this);
                if (objM == objF) {
                    return objF;
                }
                n8 = n9;
                obj = objM;
            } else {
                if (i8 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                n8 = (N) this.L$0;
                AbstractC2491s.b(obj);
            }
            n8.f20469a = obj;
            return C2470H.f21956a;
        }
    }

    /* JADX INFO: renamed from: io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$getDouble$1, reason: invalid class name and case insensitive filesystem */
    @InterfaceC2779f(c = "io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$getDouble$1", f = "SharedPreferencesPlugin.kt", l = {188}, m = "invokeSuspend")
    public static final class C20441 extends AbstractC2785l implements B5.o {
        final /* synthetic */ String $key;
        final /* synthetic */ N $value;
        Object L$0;
        int label;
        final /* synthetic */ SharedPreferencesPlugin this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C20441(String str, SharedPreferencesPlugin sharedPreferencesPlugin, N n8, InterfaceC2707e interfaceC2707e) {
            super(2, interfaceC2707e);
            this.$key = str;
            this.this$0 = sharedPreferencesPlugin;
            this.$value = n8;
        }

        @Override // u5.AbstractC2774a
        public final InterfaceC2707e create(Object obj, InterfaceC2707e interfaceC2707e) {
            return new C20441(this.$key, this.this$0, this.$value, interfaceC2707e);
        }

        @Override // B5.o
        public final Object invoke(L l8, InterfaceC2707e interfaceC2707e) {
            return ((C20441) create(l8, interfaceC2707e)).invokeSuspend(C2470H.f21956a);
        }

        @Override // u5.AbstractC2774a
        public final Object invokeSuspend(Object obj) throws Throwable {
            N n8;
            Object objF = AbstractC2751c.f();
            int i8 = this.label;
            if (i8 == 0) {
                AbstractC2491s.b(obj);
                final AbstractC1776f.a aVarG = AbstractC1778h.g(this.$key);
                Context context = this.this$0.context;
                if (context == null) {
                    AbstractC2304t.s("context");
                    context = null;
                }
                final b7.d data = SharedPreferencesPluginKt.getSharedPreferencesDataStore(context).getData();
                final SharedPreferencesPlugin sharedPreferencesPlugin = this.this$0;
                b7.d dVar = new b7.d() { // from class: io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$getDouble$1$invokeSuspend$$inlined$map$1

                    /* JADX INFO: renamed from: io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$getDouble$1$invokeSuspend$$inlined$map$1$2, reason: invalid class name */
                    public static final class AnonymousClass2<T> implements b7.e {
                        final /* synthetic */ AbstractC1776f.a $preferencesKey$inlined;
                        final /* synthetic */ b7.e $this_unsafeFlow;
                        final /* synthetic */ SharedPreferencesPlugin this$0;

                        /* JADX INFO: renamed from: io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$getDouble$1$invokeSuspend$$inlined$map$1$2$1, reason: invalid class name */
                        @InterfaceC2779f(c = "io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$getDouble$1$invokeSuspend$$inlined$map$1$2", f = "SharedPreferencesPlugin.kt", l = {223}, m = "emit")
                        public static final class AnonymousClass1 extends AbstractC2777d {
                            Object L$0;
                            int label;
                            /* synthetic */ Object result;

                            public AnonymousClass1(InterfaceC2707e interfaceC2707e) {
                                super(interfaceC2707e);
                            }

                            @Override // u5.AbstractC2774a
                            public final Object invokeSuspend(Object obj) {
                                this.result = obj;
                                this.label |= Integer.MIN_VALUE;
                                return AnonymousClass2.this.emit(null, this);
                            }
                        }

                        public AnonymousClass2(b7.e eVar, AbstractC1776f.a aVar, SharedPreferencesPlugin sharedPreferencesPlugin) {
                            this.$this_unsafeFlow = eVar;
                            this.$preferencesKey$inlined = aVar;
                            this.this$0 = sharedPreferencesPlugin;
                        }

                        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                        @Override // b7.e
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                            To view partially-correct add '--show-bad-code' argument
                        */
                        public final java.lang.Object emit(java.lang.Object r5, s5.InterfaceC2707e r6) throws java.lang.Throwable {
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
                                java.lang.Object r1 = t5.AbstractC2751c.f()
                                int r2 = r0.label
                                r3 = 1
                                if (r2 == 0) goto L31
                                if (r2 != r3) goto L29
                                o5.AbstractC2491s.b(r6)
                                goto L53
                            L29:
                                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                                java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                                r5.<init>(r6)
                                throw r5
                            L31:
                                o5.AbstractC2491s.b(r6)
                                b7.e r6 = r4.$this_unsafeFlow
                                g0.f r5 = (g0.AbstractC1776f) r5
                                g0.f$a r2 = r4.$preferencesKey$inlined
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
                                o5.H r5 = o5.C2470H.f21956a
                                return r5
                            */
                            throw new UnsupportedOperationException("Method not decompiled: io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$getDouble$1$invokeSuspend$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, s5.e):java.lang.Object");
                        }
                    }

                    @Override // b7.d
                    public Object collect(b7.e eVar, InterfaceC2707e interfaceC2707e) {
                        Object objCollect = data.collect(new AnonymousClass2(eVar, aVarG, sharedPreferencesPlugin), interfaceC2707e);
                        return objCollect == AbstractC2751c.f() ? objCollect : C2470H.f21956a;
                    }
                };
                N n9 = this.$value;
                this.L$0 = n9;
                this.label = 1;
                Object objM = b7.f.m(dVar, this);
                if (objM == objF) {
                    return objF;
                }
                n8 = n9;
                obj = objM;
            } else {
                if (i8 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                n8 = (N) this.L$0;
                AbstractC2491s.b(obj);
            }
            n8.f20469a = obj;
            return C2470H.f21956a;
        }
    }

    /* JADX INFO: renamed from: io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$getInt$1, reason: invalid class name and case insensitive filesystem */
    @InterfaceC2779f(c = "io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$getInt$1", f = "SharedPreferencesPlugin.kt", l = {160}, m = "invokeSuspend")
    public static final class C20451 extends AbstractC2785l implements B5.o {
        final /* synthetic */ String $key;
        final /* synthetic */ N $value;
        Object L$0;
        int label;
        final /* synthetic */ SharedPreferencesPlugin this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C20451(String str, SharedPreferencesPlugin sharedPreferencesPlugin, N n8, InterfaceC2707e interfaceC2707e) {
            super(2, interfaceC2707e);
            this.$key = str;
            this.this$0 = sharedPreferencesPlugin;
            this.$value = n8;
        }

        @Override // u5.AbstractC2774a
        public final InterfaceC2707e create(Object obj, InterfaceC2707e interfaceC2707e) {
            return new C20451(this.$key, this.this$0, this.$value, interfaceC2707e);
        }

        @Override // B5.o
        public final Object invoke(L l8, InterfaceC2707e interfaceC2707e) {
            return ((C20451) create(l8, interfaceC2707e)).invokeSuspend(C2470H.f21956a);
        }

        @Override // u5.AbstractC2774a
        public final Object invokeSuspend(Object obj) throws Throwable {
            N n8;
            Object objF = AbstractC2751c.f();
            int i8 = this.label;
            if (i8 == 0) {
                AbstractC2491s.b(obj);
                final AbstractC1776f.a aVarF = AbstractC1778h.f(this.$key);
                Context context = this.this$0.context;
                if (context == null) {
                    AbstractC2304t.s("context");
                    context = null;
                }
                final b7.d data = SharedPreferencesPluginKt.getSharedPreferencesDataStore(context).getData();
                b7.d dVar = new b7.d() { // from class: io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$getInt$1$invokeSuspend$$inlined$map$1

                    /* JADX INFO: renamed from: io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$getInt$1$invokeSuspend$$inlined$map$1$2, reason: invalid class name */
                    public static final class AnonymousClass2<T> implements b7.e {
                        final /* synthetic */ AbstractC1776f.a $preferencesKey$inlined;
                        final /* synthetic */ b7.e $this_unsafeFlow;

                        /* JADX INFO: renamed from: io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$getInt$1$invokeSuspend$$inlined$map$1$2$1, reason: invalid class name */
                        @InterfaceC2779f(c = "io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$getInt$1$invokeSuspend$$inlined$map$1$2", f = "SharedPreferencesPlugin.kt", l = {223}, m = "emit")
                        public static final class AnonymousClass1 extends AbstractC2777d {
                            Object L$0;
                            int label;
                            /* synthetic */ Object result;

                            public AnonymousClass1(InterfaceC2707e interfaceC2707e) {
                                super(interfaceC2707e);
                            }

                            @Override // u5.AbstractC2774a
                            public final Object invokeSuspend(Object obj) {
                                this.result = obj;
                                this.label |= Integer.MIN_VALUE;
                                return AnonymousClass2.this.emit(null, this);
                            }
                        }

                        public AnonymousClass2(b7.e eVar, AbstractC1776f.a aVar) {
                            this.$this_unsafeFlow = eVar;
                            this.$preferencesKey$inlined = aVar;
                        }

                        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                        @Override // b7.e
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                            To view partially-correct add '--show-bad-code' argument
                        */
                        public final java.lang.Object emit(java.lang.Object r5, s5.InterfaceC2707e r6) throws java.lang.Throwable {
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
                                java.lang.Object r1 = t5.AbstractC2751c.f()
                                int r2 = r0.label
                                r3 = 1
                                if (r2 == 0) goto L31
                                if (r2 != r3) goto L29
                                o5.AbstractC2491s.b(r6)
                                goto L47
                            L29:
                                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                                java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                                r5.<init>(r6)
                                throw r5
                            L31:
                                o5.AbstractC2491s.b(r6)
                                b7.e r6 = r4.$this_unsafeFlow
                                g0.f r5 = (g0.AbstractC1776f) r5
                                g0.f$a r2 = r4.$preferencesKey$inlined
                                java.lang.Object r5 = r5.b(r2)
                                r0.label = r3
                                java.lang.Object r5 = r6.emit(r5, r0)
                                if (r5 != r1) goto L47
                                return r1
                            L47:
                                o5.H r5 = o5.C2470H.f21956a
                                return r5
                            */
                            throw new UnsupportedOperationException("Method not decompiled: io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$getInt$1$invokeSuspend$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, s5.e):java.lang.Object");
                        }
                    }

                    @Override // b7.d
                    public Object collect(b7.e eVar, InterfaceC2707e interfaceC2707e) {
                        Object objCollect = data.collect(new AnonymousClass2(eVar, aVarF), interfaceC2707e);
                        return objCollect == AbstractC2751c.f() ? objCollect : C2470H.f21956a;
                    }
                };
                N n9 = this.$value;
                this.L$0 = n9;
                this.label = 1;
                Object objM = b7.f.m(dVar, this);
                if (objM == objF) {
                    return objF;
                }
                n8 = n9;
                obj = objM;
            } else {
                if (i8 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                n8 = (N) this.L$0;
                AbstractC2491s.b(obj);
            }
            n8.f20469a = obj;
            return C2470H.f21956a;
        }
    }

    /* JADX INFO: renamed from: io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$getPrefs$1, reason: invalid class name and case insensitive filesystem */
    @InterfaceC2779f(c = "io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin", f = "SharedPreferencesPlugin.kt", l = {256, 258}, m = "getPrefs")
    public static final class C20461 extends AbstractC2777d {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        public C20461(InterfaceC2707e interfaceC2707e) {
            super(interfaceC2707e);
        }

        @Override // u5.AbstractC2774a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SharedPreferencesPlugin.this.getPrefs(null, this);
        }
    }

    /* JADX INFO: renamed from: io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$getString$1, reason: invalid class name and case insensitive filesystem */
    @InterfaceC2779f(c = "io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$getString$1", f = "SharedPreferencesPlugin.kt", l = {RCHTTPStatusCodes.CREATED}, m = "invokeSuspend")
    public static final class C20471 extends AbstractC2785l implements B5.o {
        final /* synthetic */ String $key;
        final /* synthetic */ N $value;
        Object L$0;
        int label;
        final /* synthetic */ SharedPreferencesPlugin this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C20471(String str, SharedPreferencesPlugin sharedPreferencesPlugin, N n8, InterfaceC2707e interfaceC2707e) {
            super(2, interfaceC2707e);
            this.$key = str;
            this.this$0 = sharedPreferencesPlugin;
            this.$value = n8;
        }

        @Override // u5.AbstractC2774a
        public final InterfaceC2707e create(Object obj, InterfaceC2707e interfaceC2707e) {
            return new C20471(this.$key, this.this$0, this.$value, interfaceC2707e);
        }

        @Override // B5.o
        public final Object invoke(L l8, InterfaceC2707e interfaceC2707e) {
            return ((C20471) create(l8, interfaceC2707e)).invokeSuspend(C2470H.f21956a);
        }

        @Override // u5.AbstractC2774a
        public final Object invokeSuspend(Object obj) throws Throwable {
            N n8;
            Object objF = AbstractC2751c.f();
            int i8 = this.label;
            if (i8 == 0) {
                AbstractC2491s.b(obj);
                final AbstractC1776f.a aVarG = AbstractC1778h.g(this.$key);
                Context context = this.this$0.context;
                if (context == null) {
                    AbstractC2304t.s("context");
                    context = null;
                }
                final b7.d data = SharedPreferencesPluginKt.getSharedPreferencesDataStore(context).getData();
                b7.d dVar = new b7.d() { // from class: io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$getString$1$invokeSuspend$$inlined$map$1

                    /* JADX INFO: renamed from: io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$getString$1$invokeSuspend$$inlined$map$1$2, reason: invalid class name */
                    public static final class AnonymousClass2<T> implements b7.e {
                        final /* synthetic */ AbstractC1776f.a $preferencesKey$inlined;
                        final /* synthetic */ b7.e $this_unsafeFlow;

                        /* JADX INFO: renamed from: io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$getString$1$invokeSuspend$$inlined$map$1$2$1, reason: invalid class name */
                        @InterfaceC2779f(c = "io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$getString$1$invokeSuspend$$inlined$map$1$2", f = "SharedPreferencesPlugin.kt", l = {223}, m = "emit")
                        public static final class AnonymousClass1 extends AbstractC2777d {
                            Object L$0;
                            int label;
                            /* synthetic */ Object result;

                            public AnonymousClass1(InterfaceC2707e interfaceC2707e) {
                                super(interfaceC2707e);
                            }

                            @Override // u5.AbstractC2774a
                            public final Object invokeSuspend(Object obj) {
                                this.result = obj;
                                this.label |= Integer.MIN_VALUE;
                                return AnonymousClass2.this.emit(null, this);
                            }
                        }

                        public AnonymousClass2(b7.e eVar, AbstractC1776f.a aVar) {
                            this.$this_unsafeFlow = eVar;
                            this.$preferencesKey$inlined = aVar;
                        }

                        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                        @Override // b7.e
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                            To view partially-correct add '--show-bad-code' argument
                        */
                        public final java.lang.Object emit(java.lang.Object r5, s5.InterfaceC2707e r6) throws java.lang.Throwable {
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
                                java.lang.Object r1 = t5.AbstractC2751c.f()
                                int r2 = r0.label
                                r3 = 1
                                if (r2 == 0) goto L31
                                if (r2 != r3) goto L29
                                o5.AbstractC2491s.b(r6)
                                goto L47
                            L29:
                                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                                java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                                r5.<init>(r6)
                                throw r5
                            L31:
                                o5.AbstractC2491s.b(r6)
                                b7.e r6 = r4.$this_unsafeFlow
                                g0.f r5 = (g0.AbstractC1776f) r5
                                g0.f$a r2 = r4.$preferencesKey$inlined
                                java.lang.Object r5 = r5.b(r2)
                                r0.label = r3
                                java.lang.Object r5 = r6.emit(r5, r0)
                                if (r5 != r1) goto L47
                                return r1
                            L47:
                                o5.H r5 = o5.C2470H.f21956a
                                return r5
                            */
                            throw new UnsupportedOperationException("Method not decompiled: io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$getString$1$invokeSuspend$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, s5.e):java.lang.Object");
                        }
                    }

                    @Override // b7.d
                    public Object collect(b7.e eVar, InterfaceC2707e interfaceC2707e) {
                        Object objCollect = data.collect(new AnonymousClass2(eVar, aVarG), interfaceC2707e);
                        return objCollect == AbstractC2751c.f() ? objCollect : C2470H.f21956a;
                    }
                };
                N n9 = this.$value;
                this.L$0 = n9;
                this.label = 1;
                Object objM = b7.f.m(dVar, this);
                if (objM == objF) {
                    return objF;
                }
                n8 = n9;
                obj = objM;
            } else {
                if (i8 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                n8 = (N) this.L$0;
                AbstractC2491s.b(obj);
            }
            n8.f20469a = obj;
            return C2470H.f21956a;
        }
    }

    /* JADX INFO: renamed from: io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$setBool$1, reason: invalid class name and case insensitive filesystem */
    @InterfaceC2779f(c = "io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$setBool$1", f = "SharedPreferencesPlugin.kt", l = {81}, m = "invokeSuspend")
    public static final class C20481 extends AbstractC2785l implements B5.o {
        final /* synthetic */ String $key;
        final /* synthetic */ boolean $value;
        int label;
        final /* synthetic */ SharedPreferencesPlugin this$0;

        /* JADX INFO: renamed from: io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$setBool$1$1, reason: invalid class name and collision with other inner class name */
        @InterfaceC2779f(c = "io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$setBool$1$1", f = "SharedPreferencesPlugin.kt", l = {}, m = "invokeSuspend")
        public static final class C03211 extends AbstractC2785l implements B5.o {
            final /* synthetic */ AbstractC1776f.a $boolKey;
            final /* synthetic */ boolean $value;
            /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C03211(AbstractC1776f.a aVar, boolean z7, InterfaceC2707e interfaceC2707e) {
                super(2, interfaceC2707e);
                this.$boolKey = aVar;
                this.$value = z7;
            }

            @Override // u5.AbstractC2774a
            public final InterfaceC2707e create(Object obj, InterfaceC2707e interfaceC2707e) {
                C03211 c03211 = new C03211(this.$boolKey, this.$value, interfaceC2707e);
                c03211.L$0 = obj;
                return c03211;
            }

            @Override // B5.o
            public final Object invoke(C1773c c1773c, InterfaceC2707e interfaceC2707e) {
                return ((C03211) create(c1773c, interfaceC2707e)).invokeSuspend(C2470H.f21956a);
            }

            @Override // u5.AbstractC2774a
            public final Object invokeSuspend(Object obj) throws Throwable {
                AbstractC2751c.f();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC2491s.b(obj);
                ((C1773c) this.L$0).j(this.$boolKey, AbstractC2775b.a(this.$value));
                return C2470H.f21956a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C20481(String str, SharedPreferencesPlugin sharedPreferencesPlugin, boolean z7, InterfaceC2707e interfaceC2707e) {
            super(2, interfaceC2707e);
            this.$key = str;
            this.this$0 = sharedPreferencesPlugin;
            this.$value = z7;
        }

        @Override // u5.AbstractC2774a
        public final InterfaceC2707e create(Object obj, InterfaceC2707e interfaceC2707e) {
            return new C20481(this.$key, this.this$0, this.$value, interfaceC2707e);
        }

        @Override // B5.o
        public final Object invoke(L l8, InterfaceC2707e interfaceC2707e) {
            return ((C20481) create(l8, interfaceC2707e)).invokeSuspend(C2470H.f21956a);
        }

        @Override // u5.AbstractC2774a
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = AbstractC2751c.f();
            int i8 = this.label;
            if (i8 == 0) {
                AbstractC2491s.b(obj);
                AbstractC1776f.a aVarA = AbstractC1778h.a(this.$key);
                Context context = this.this$0.context;
                if (context == null) {
                    AbstractC2304t.s("context");
                    context = null;
                }
                InterfaceC1178i sharedPreferencesDataStore = SharedPreferencesPluginKt.getSharedPreferencesDataStore(context);
                C03211 c03211 = new C03211(aVarA, this.$value, null);
                this.label = 1;
                if (AbstractC1779i.a(sharedPreferencesDataStore, c03211, this) == objF) {
                    return objF;
                }
            } else {
                if (i8 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC2491s.b(obj);
            }
            return C2470H.f21956a;
        }
    }

    /* JADX INFO: renamed from: io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$setDeprecatedStringList$1, reason: invalid class name and case insensitive filesystem */
    @InterfaceC2779f(c = "io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$setDeprecatedStringList$1", f = "SharedPreferencesPlugin.kt", l = {128}, m = "invokeSuspend")
    public static final class C20491 extends AbstractC2785l implements B5.o {
        final /* synthetic */ String $key;
        final /* synthetic */ String $valueString;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C20491(String str, String str2, InterfaceC2707e interfaceC2707e) {
            super(2, interfaceC2707e);
            this.$key = str;
            this.$valueString = str2;
        }

        @Override // u5.AbstractC2774a
        public final InterfaceC2707e create(Object obj, InterfaceC2707e interfaceC2707e) {
            return SharedPreferencesPlugin.this.new C20491(this.$key, this.$valueString, interfaceC2707e);
        }

        @Override // B5.o
        public final Object invoke(L l8, InterfaceC2707e interfaceC2707e) {
            return ((C20491) create(l8, interfaceC2707e)).invokeSuspend(C2470H.f21956a);
        }

        @Override // u5.AbstractC2774a
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = AbstractC2751c.f();
            int i8 = this.label;
            if (i8 == 0) {
                AbstractC2491s.b(obj);
                SharedPreferencesPlugin sharedPreferencesPlugin = SharedPreferencesPlugin.this;
                String str = this.$key;
                String str2 = this.$valueString;
                this.label = 1;
                if (sharedPreferencesPlugin.dataStoreSetString(str, str2, this) == objF) {
                    return objF;
                }
            } else {
                if (i8 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC2491s.b(obj);
            }
            return C2470H.f21956a;
        }
    }

    /* JADX INFO: renamed from: io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$setDouble$1, reason: invalid class name and case insensitive filesystem */
    @InterfaceC2779f(c = "io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$setDouble$1", f = "SharedPreferencesPlugin.kt", l = {107}, m = "invokeSuspend")
    public static final class C20501 extends AbstractC2785l implements B5.o {
        final /* synthetic */ String $key;
        final /* synthetic */ double $value;
        int label;
        final /* synthetic */ SharedPreferencesPlugin this$0;

        /* JADX INFO: renamed from: io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$setDouble$1$1, reason: invalid class name and collision with other inner class name */
        @InterfaceC2779f(c = "io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$setDouble$1$1", f = "SharedPreferencesPlugin.kt", l = {}, m = "invokeSuspend")
        public static final class C03221 extends AbstractC2785l implements B5.o {
            final /* synthetic */ AbstractC1776f.a $doubleKey;
            final /* synthetic */ double $value;
            /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C03221(AbstractC1776f.a aVar, double d8, InterfaceC2707e interfaceC2707e) {
                super(2, interfaceC2707e);
                this.$doubleKey = aVar;
                this.$value = d8;
            }

            @Override // u5.AbstractC2774a
            public final InterfaceC2707e create(Object obj, InterfaceC2707e interfaceC2707e) {
                C03221 c03221 = new C03221(this.$doubleKey, this.$value, interfaceC2707e);
                c03221.L$0 = obj;
                return c03221;
            }

            @Override // B5.o
            public final Object invoke(C1773c c1773c, InterfaceC2707e interfaceC2707e) {
                return ((C03221) create(c1773c, interfaceC2707e)).invokeSuspend(C2470H.f21956a);
            }

            @Override // u5.AbstractC2774a
            public final Object invokeSuspend(Object obj) throws Throwable {
                AbstractC2751c.f();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC2491s.b(obj);
                ((C1773c) this.L$0).j(this.$doubleKey, AbstractC2775b.b(this.$value));
                return C2470H.f21956a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C20501(String str, SharedPreferencesPlugin sharedPreferencesPlugin, double d8, InterfaceC2707e interfaceC2707e) {
            super(2, interfaceC2707e);
            this.$key = str;
            this.this$0 = sharedPreferencesPlugin;
            this.$value = d8;
        }

        @Override // u5.AbstractC2774a
        public final InterfaceC2707e create(Object obj, InterfaceC2707e interfaceC2707e) {
            return new C20501(this.$key, this.this$0, this.$value, interfaceC2707e);
        }

        @Override // B5.o
        public final Object invoke(L l8, InterfaceC2707e interfaceC2707e) {
            return ((C20501) create(l8, interfaceC2707e)).invokeSuspend(C2470H.f21956a);
        }

        @Override // u5.AbstractC2774a
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = AbstractC2751c.f();
            int i8 = this.label;
            if (i8 == 0) {
                AbstractC2491s.b(obj);
                AbstractC1776f.a aVarC = AbstractC1778h.c(this.$key);
                Context context = this.this$0.context;
                if (context == null) {
                    AbstractC2304t.s("context");
                    context = null;
                }
                InterfaceC1178i sharedPreferencesDataStore = SharedPreferencesPluginKt.getSharedPreferencesDataStore(context);
                C03221 c03221 = new C03221(aVarC, this.$value, null);
                this.label = 1;
                if (AbstractC1779i.a(sharedPreferencesDataStore, c03221, this) == objF) {
                    return objF;
                }
            } else {
                if (i8 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC2491s.b(obj);
            }
            return C2470H.f21956a;
        }
    }

    /* JADX INFO: renamed from: io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$setEncodedStringList$1, reason: invalid class name and case insensitive filesystem */
    @InterfaceC2779f(c = "io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$setEncodedStringList$1", f = "SharedPreferencesPlugin.kt", l = {117}, m = "invokeSuspend")
    public static final class C20511 extends AbstractC2785l implements B5.o {
        final /* synthetic */ String $key;
        final /* synthetic */ String $value;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C20511(String str, String str2, InterfaceC2707e interfaceC2707e) {
            super(2, interfaceC2707e);
            this.$key = str;
            this.$value = str2;
        }

        @Override // u5.AbstractC2774a
        public final InterfaceC2707e create(Object obj, InterfaceC2707e interfaceC2707e) {
            return SharedPreferencesPlugin.this.new C20511(this.$key, this.$value, interfaceC2707e);
        }

        @Override // B5.o
        public final Object invoke(L l8, InterfaceC2707e interfaceC2707e) {
            return ((C20511) create(l8, interfaceC2707e)).invokeSuspend(C2470H.f21956a);
        }

        @Override // u5.AbstractC2774a
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = AbstractC2751c.f();
            int i8 = this.label;
            if (i8 == 0) {
                AbstractC2491s.b(obj);
                SharedPreferencesPlugin sharedPreferencesPlugin = SharedPreferencesPlugin.this;
                String str = this.$key;
                String str2 = this.$value;
                this.label = 1;
                if (sharedPreferencesPlugin.dataStoreSetString(str, str2, this) == objF) {
                    return objF;
                }
            } else {
                if (i8 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC2491s.b(obj);
            }
            return C2470H.f21956a;
        }
    }

    /* JADX INFO: renamed from: io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$setInt$1, reason: invalid class name and case insensitive filesystem */
    @InterfaceC2779f(c = "io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$setInt$1", f = "SharedPreferencesPlugin.kt", l = {99}, m = "invokeSuspend")
    public static final class C20521 extends AbstractC2785l implements B5.o {
        final /* synthetic */ String $key;
        final /* synthetic */ long $value;
        int label;
        final /* synthetic */ SharedPreferencesPlugin this$0;

        /* JADX INFO: renamed from: io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$setInt$1$1, reason: invalid class name and collision with other inner class name */
        @InterfaceC2779f(c = "io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$setInt$1$1", f = "SharedPreferencesPlugin.kt", l = {}, m = "invokeSuspend")
        public static final class C03231 extends AbstractC2785l implements B5.o {
            final /* synthetic */ AbstractC1776f.a $intKey;
            final /* synthetic */ long $value;
            /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C03231(AbstractC1776f.a aVar, long j8, InterfaceC2707e interfaceC2707e) {
                super(2, interfaceC2707e);
                this.$intKey = aVar;
                this.$value = j8;
            }

            @Override // u5.AbstractC2774a
            public final InterfaceC2707e create(Object obj, InterfaceC2707e interfaceC2707e) {
                C03231 c03231 = new C03231(this.$intKey, this.$value, interfaceC2707e);
                c03231.L$0 = obj;
                return c03231;
            }

            @Override // B5.o
            public final Object invoke(C1773c c1773c, InterfaceC2707e interfaceC2707e) {
                return ((C03231) create(c1773c, interfaceC2707e)).invokeSuspend(C2470H.f21956a);
            }

            @Override // u5.AbstractC2774a
            public final Object invokeSuspend(Object obj) throws Throwable {
                AbstractC2751c.f();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC2491s.b(obj);
                ((C1773c) this.L$0).j(this.$intKey, AbstractC2775b.d(this.$value));
                return C2470H.f21956a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C20521(String str, SharedPreferencesPlugin sharedPreferencesPlugin, long j8, InterfaceC2707e interfaceC2707e) {
            super(2, interfaceC2707e);
            this.$key = str;
            this.this$0 = sharedPreferencesPlugin;
            this.$value = j8;
        }

        @Override // u5.AbstractC2774a
        public final InterfaceC2707e create(Object obj, InterfaceC2707e interfaceC2707e) {
            return new C20521(this.$key, this.this$0, this.$value, interfaceC2707e);
        }

        @Override // B5.o
        public final Object invoke(L l8, InterfaceC2707e interfaceC2707e) {
            return ((C20521) create(l8, interfaceC2707e)).invokeSuspend(C2470H.f21956a);
        }

        @Override // u5.AbstractC2774a
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = AbstractC2751c.f();
            int i8 = this.label;
            if (i8 == 0) {
                AbstractC2491s.b(obj);
                AbstractC1776f.a aVarF = AbstractC1778h.f(this.$key);
                Context context = this.this$0.context;
                if (context == null) {
                    AbstractC2304t.s("context");
                    context = null;
                }
                InterfaceC1178i sharedPreferencesDataStore = SharedPreferencesPluginKt.getSharedPreferencesDataStore(context);
                C03231 c03231 = new C03231(aVarF, this.$value, null);
                this.label = 1;
                if (AbstractC1779i.a(sharedPreferencesDataStore, c03231, this) == objF) {
                    return objF;
                }
            } else {
                if (i8 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC2491s.b(obj);
            }
            return C2470H.f21956a;
        }
    }

    /* JADX INFO: renamed from: io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$setString$1, reason: invalid class name and case insensitive filesystem */
    @InterfaceC2779f(c = "io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$setString$1", f = "SharedPreferencesPlugin.kt", l = {87}, m = "invokeSuspend")
    public static final class C20531 extends AbstractC2785l implements B5.o {
        final /* synthetic */ String $key;
        final /* synthetic */ String $value;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C20531(String str, String str2, InterfaceC2707e interfaceC2707e) {
            super(2, interfaceC2707e);
            this.$key = str;
            this.$value = str2;
        }

        @Override // u5.AbstractC2774a
        public final InterfaceC2707e create(Object obj, InterfaceC2707e interfaceC2707e) {
            return SharedPreferencesPlugin.this.new C20531(this.$key, this.$value, interfaceC2707e);
        }

        @Override // B5.o
        public final Object invoke(L l8, InterfaceC2707e interfaceC2707e) {
            return ((C20531) create(l8, interfaceC2707e)).invokeSuspend(C2470H.f21956a);
        }

        @Override // u5.AbstractC2774a
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = AbstractC2751c.f();
            int i8 = this.label;
            if (i8 == 0) {
                AbstractC2491s.b(obj);
                SharedPreferencesPlugin sharedPreferencesPlugin = SharedPreferencesPlugin.this;
                String str = this.$key;
                String str2 = this.$value;
                this.label = 1;
                if (sharedPreferencesPlugin.dataStoreSetString(str, str2, this) == objF) {
                    return objF;
                }
            } else {
                if (i8 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC2491s.b(obj);
            }
            return C2470H.f21956a;
        }
    }

    public SharedPreferencesPlugin() {
        this.listEncoder = new ListEncoder();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object dataStoreSetString(String str, String str2, InterfaceC2707e interfaceC2707e) {
        AbstractC1776f.a aVarG = AbstractC1778h.g(str);
        Context context = this.context;
        if (context == null) {
            AbstractC2304t.s("context");
            context = null;
        }
        Object objA = AbstractC1779i.a(SharedPreferencesPluginKt.getSharedPreferencesDataStore(context), new AnonymousClass2(aVarG, str2, null), interfaceC2707e);
        return objA == AbstractC2751c.f() ? objA : C2470H.f21956a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:30:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x00a2 -> B:33:0x00a5). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object getPrefs(java.util.List<java.lang.String> r9, s5.InterfaceC2707e r10) throws java.lang.Throwable {
        /*
            r8 = this;
            boolean r0 = r10 instanceof io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin.C20461
            if (r0 == 0) goto L13
            r0 = r10
            io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$getPrefs$1 r0 = (io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin.C20461) r0
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
            java.lang.Object r1 = t5.AbstractC2751c.f()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L58
            if (r2 == r4) goto L48
            if (r2 != r3) goto L40
            java.lang.Object r9 = r0.L$4
            g0.f$a r9 = (g0.AbstractC1776f.a) r9
            java.lang.Object r2 = r0.L$3
            java.util.Iterator r2 = (java.util.Iterator) r2
            java.lang.Object r4 = r0.L$2
            java.util.Map r4 = (java.util.Map) r4
            java.lang.Object r5 = r0.L$1
            java.util.Set r5 = (java.util.Set) r5
            java.lang.Object r6 = r0.L$0
            io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin r6 = (io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin) r6
            o5.AbstractC2491s.b(r10)
            goto La5
        L40:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L48:
            java.lang.Object r9 = r0.L$2
            java.util.Map r9 = (java.util.Map) r9
            java.lang.Object r2 = r0.L$1
            java.util.Set r2 = (java.util.Set) r2
            java.lang.Object r4 = r0.L$0
            io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin r4 = (io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin) r4
            o5.AbstractC2491s.b(r10)
            goto L7a
        L58:
            o5.AbstractC2491s.b(r10)
            if (r9 == 0) goto L63
            java.util.Set r9 = p5.z.K0(r9)
        L61:
            r2 = r9
            goto L65
        L63:
            r9 = 0
            goto L61
        L65:
            java.util.LinkedHashMap r9 = new java.util.LinkedHashMap
            r9.<init>()
            r0.L$0 = r8
            r0.L$1 = r2
            r0.L$2 = r9
            r0.label = r4
            java.lang.Object r10 = r8.readAllKeys(r0)
            if (r10 != r1) goto L79
            return r1
        L79:
            r4 = r8
        L7a:
            java.util.Set r10 = (java.util.Set) r10
            if (r10 == 0) goto Lc0
            java.util.Iterator r10 = r10.iterator()
            r5 = r2
            r6 = r4
            r4 = r9
            r2 = r10
        L86:
            boolean r9 = r2.hasNext()
            if (r9 == 0) goto Lbf
            java.lang.Object r9 = r2.next()
            g0.f$a r9 = (g0.AbstractC1776f.a) r9
            r0.L$0 = r6
            r0.L$1 = r5
            r0.L$2 = r4
            r0.L$3 = r2
            r0.L$4 = r9
            r0.label = r3
            java.lang.Object r10 = r6.getValueByKey(r9, r0)
            if (r10 != r1) goto La5
            return r1
        La5:
            java.lang.String r7 = r9.toString()
            boolean r7 = io.flutter.plugins.sharedpreferences.SharedPreferencesPluginKt.preferencesFilter(r7, r10, r5)
            if (r7 == 0) goto L86
            io.flutter.plugins.sharedpreferences.SharedPreferencesListEncoder r7 = r6.listEncoder
            java.lang.Object r10 = io.flutter.plugins.sharedpreferences.SharedPreferencesPluginKt.transformPref(r10, r7)
            if (r10 == 0) goto L86
            java.lang.String r9 = r9.toString()
            r4.put(r9, r10)
            goto L86
        Lbf:
            r9 = r4
        Lc0:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin.getPrefs(java.util.List, s5.e):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object getValueByKey(final AbstractC1776f.a aVar, InterfaceC2707e interfaceC2707e) {
        Context context = this.context;
        if (context == null) {
            AbstractC2304t.s("context");
            context = null;
        }
        final b7.d data = SharedPreferencesPluginKt.getSharedPreferencesDataStore(context).getData();
        return b7.f.m(new b7.d() { // from class: io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$getValueByKey$$inlined$map$1

            /* JADX INFO: renamed from: io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$getValueByKey$$inlined$map$1$2, reason: invalid class name */
            public static final class AnonymousClass2<T> implements b7.e {
                final /* synthetic */ AbstractC1776f.a $key$inlined;
                final /* synthetic */ b7.e $this_unsafeFlow;

                /* JADX INFO: renamed from: io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$getValueByKey$$inlined$map$1$2$1, reason: invalid class name */
                @InterfaceC2779f(c = "io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$getValueByKey$$inlined$map$1$2", f = "SharedPreferencesPlugin.kt", l = {223}, m = "emit")
                public static final class AnonymousClass1 extends AbstractC2777d {
                    Object L$0;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(InterfaceC2707e interfaceC2707e) {
                        super(interfaceC2707e);
                    }

                    @Override // u5.AbstractC2774a
                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(b7.e eVar, AbstractC1776f.a aVar) {
                    this.$this_unsafeFlow = eVar;
                    this.$key$inlined = aVar;
                }

                /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                @Override // b7.e
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object emit(java.lang.Object r5, s5.InterfaceC2707e r6) throws java.lang.Throwable {
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
                        java.lang.Object r1 = t5.AbstractC2751c.f()
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        o5.AbstractC2491s.b(r6)
                        goto L47
                    L29:
                        java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                        java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                        r5.<init>(r6)
                        throw r5
                    L31:
                        o5.AbstractC2491s.b(r6)
                        b7.e r6 = r4.$this_unsafeFlow
                        g0.f r5 = (g0.AbstractC1776f) r5
                        g0.f$a r2 = r4.$key$inlined
                        java.lang.Object r5 = r5.b(r2)
                        r0.label = r3
                        java.lang.Object r5 = r6.emit(r5, r0)
                        if (r5 != r1) goto L47
                        return r1
                    L47:
                        o5.H r5 = o5.C2470H.f21956a
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$getValueByKey$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, s5.e):java.lang.Object");
                }
            }

            @Override // b7.d
            public Object collect(b7.e eVar, InterfaceC2707e interfaceC2707e2) {
                Object objCollect = data.collect(new AnonymousClass2(eVar, aVar), interfaceC2707e2);
                return objCollect == AbstractC2751c.f() ? objCollect : C2470H.f21956a;
            }
        }, interfaceC2707e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object readAllKeys(InterfaceC2707e interfaceC2707e) {
        Context context = this.context;
        if (context == null) {
            AbstractC2304t.s("context");
            context = null;
        }
        final b7.d data = SharedPreferencesPluginKt.getSharedPreferencesDataStore(context).getData();
        return b7.f.m(new b7.d() { // from class: io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$readAllKeys$$inlined$map$1

            /* JADX INFO: renamed from: io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$readAllKeys$$inlined$map$1$2, reason: invalid class name */
            public static final class AnonymousClass2<T> implements b7.e {
                final /* synthetic */ b7.e $this_unsafeFlow;

                /* JADX INFO: renamed from: io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$readAllKeys$$inlined$map$1$2$1, reason: invalid class name */
                @InterfaceC2779f(c = "io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$readAllKeys$$inlined$map$1$2", f = "SharedPreferencesPlugin.kt", l = {223}, m = "emit")
                public static final class AnonymousClass1 extends AbstractC2777d {
                    Object L$0;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(InterfaceC2707e interfaceC2707e) {
                        super(interfaceC2707e);
                    }

                    @Override // u5.AbstractC2774a
                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(b7.e eVar) {
                    this.$this_unsafeFlow = eVar;
                }

                /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                @Override // b7.e
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object emit(java.lang.Object r5, s5.InterfaceC2707e r6) throws java.lang.Throwable {
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
                        java.lang.Object r1 = t5.AbstractC2751c.f()
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        o5.AbstractC2491s.b(r6)
                        goto L49
                    L29:
                        java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                        java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                        r5.<init>(r6)
                        throw r5
                    L31:
                        o5.AbstractC2491s.b(r6)
                        b7.e r6 = r4.$this_unsafeFlow
                        g0.f r5 = (g0.AbstractC1776f) r5
                        java.util.Map r5 = r5.a()
                        java.util.Set r5 = r5.keySet()
                        r0.label = r3
                        java.lang.Object r5 = r6.emit(r5, r0)
                        if (r5 != r1) goto L49
                        return r1
                    L49:
                        o5.H r5 = o5.C2470H.f21956a
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$readAllKeys$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, s5.e):java.lang.Object");
                }
            }

            @Override // b7.d
            public Object collect(b7.e eVar, InterfaceC2707e interfaceC2707e2) {
                Object objCollect = data.collect(new AnonymousClass2(eVar), interfaceC2707e2);
                return objCollect == AbstractC2751c.f() ? objCollect : C2470H.f21956a;
            }
        }, interfaceC2707e);
    }

    private final void setUp(BinaryMessenger binaryMessenger, Context context) {
        this.context = context;
        try {
            SharedPreferencesAsyncApi.Companion.setUp(binaryMessenger, this, "data_store");
            this.backend = new SharedPreferencesBackend(binaryMessenger, context, this.listEncoder);
        } catch (Exception e8) {
            Log.e(SharedPreferencesPluginKt.TAG, "Received exception while setting up SharedPreferencesPlugin", e8);
        }
    }

    @Override // io.flutter.plugins.sharedpreferences.SharedPreferencesAsyncApi
    public void clear(List<String> list, SharedPreferencesPigeonOptions options) {
        AbstractC2304t.f(options, "options");
        AbstractC1007h.b(null, new AnonymousClass1(list, null), 1, null);
    }

    @Override // io.flutter.plugins.sharedpreferences.SharedPreferencesAsyncApi
    public Map<String, Object> getAll(List<String> list, SharedPreferencesPigeonOptions options) {
        AbstractC2304t.f(options, "options");
        return (Map) AbstractC1007h.b(null, new C20421(list, null), 1, null);
    }

    @Override // io.flutter.plugins.sharedpreferences.SharedPreferencesAsyncApi
    public Boolean getBool(String key, SharedPreferencesPigeonOptions options) {
        AbstractC2304t.f(key, "key");
        AbstractC2304t.f(options, "options");
        N n8 = new N();
        AbstractC1007h.b(null, new C20431(key, this, n8, null), 1, null);
        return (Boolean) n8.f20469a;
    }

    @Override // io.flutter.plugins.sharedpreferences.SharedPreferencesAsyncApi
    public Double getDouble(String key, SharedPreferencesPigeonOptions options) {
        AbstractC2304t.f(key, "key");
        AbstractC2304t.f(options, "options");
        N n8 = new N();
        AbstractC1007h.b(null, new C20441(key, this, n8, null), 1, null);
        return (Double) n8.f20469a;
    }

    @Override // io.flutter.plugins.sharedpreferences.SharedPreferencesAsyncApi
    public Long getInt(String key, SharedPreferencesPigeonOptions options) {
        AbstractC2304t.f(key, "key");
        AbstractC2304t.f(options, "options");
        N n8 = new N();
        AbstractC1007h.b(null, new C20451(key, this, n8, null), 1, null);
        return (Long) n8.f20469a;
    }

    @Override // io.flutter.plugins.sharedpreferences.SharedPreferencesAsyncApi
    public List<String> getKeys(List<String> list, SharedPreferencesPigeonOptions options) {
        AbstractC2304t.f(options, "options");
        return z.G0(((Map) AbstractC1007h.b(null, new SharedPreferencesPlugin$getKeys$prefs$1(this, list, null), 1, null)).keySet());
    }

    @Override // io.flutter.plugins.sharedpreferences.SharedPreferencesAsyncApi
    public List<String> getPlatformEncodedStringList(String key, SharedPreferencesPigeonOptions options) {
        List list;
        AbstractC2304t.f(key, "key");
        AbstractC2304t.f(options, "options");
        String string = getString(key, options);
        ArrayList arrayList = null;
        if (string != null && !A.G(string, SharedPreferencesPluginKt.JSON_LIST_PREFIX, false, 2, null) && A.G(string, SharedPreferencesPluginKt.LIST_PREFIX, false, 2, null) && (list = (List) SharedPreferencesPluginKt.transformPref(string, this.listEncoder)) != null) {
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
        AbstractC2304t.f(key, "key");
        AbstractC2304t.f(options, "options");
        N n8 = new N();
        AbstractC1007h.b(null, new C20471(key, this, n8, null), 1, null);
        return (String) n8.f20469a;
    }

    @Override // io.flutter.plugins.sharedpreferences.SharedPreferencesAsyncApi
    public StringListResult getStringList(String key, SharedPreferencesPigeonOptions options) {
        AbstractC2304t.f(key, "key");
        AbstractC2304t.f(options, "options");
        String string = getString(key, options);
        if (string == null) {
            return null;
        }
        if (A.G(string, SharedPreferencesPluginKt.JSON_LIST_PREFIX, false, 2, null)) {
            return new StringListResult(string, StringListLookupResultType.JSON_ENCODED);
        }
        return A.G(string, SharedPreferencesPluginKt.LIST_PREFIX, false, 2, null) ? new StringListResult(null, StringListLookupResultType.PLATFORM_ENCODED) : new StringListResult(null, StringListLookupResultType.UNEXPECTED_STRING);
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding binding) {
        AbstractC2304t.f(binding, "binding");
        BinaryMessenger binaryMessenger = binding.getBinaryMessenger();
        AbstractC2304t.e(binaryMessenger, "getBinaryMessenger(...)");
        Context applicationContext = binding.getApplicationContext();
        AbstractC2304t.e(applicationContext, "getApplicationContext(...)");
        setUp(binaryMessenger, applicationContext);
        new LegacySharedPreferencesPlugin().onAttachedToEngine(binding);
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding binding) {
        AbstractC2304t.f(binding, "binding");
        SharedPreferencesAsyncApi.Companion companion = SharedPreferencesAsyncApi.Companion;
        BinaryMessenger binaryMessenger = binding.getBinaryMessenger();
        AbstractC2304t.e(binaryMessenger, "getBinaryMessenger(...)");
        companion.setUp(binaryMessenger, null, "data_store");
        SharedPreferencesBackend sharedPreferencesBackend = this.backend;
        if (sharedPreferencesBackend != null) {
            sharedPreferencesBackend.tearDown();
        }
        this.backend = null;
    }

    @Override // io.flutter.plugins.sharedpreferences.SharedPreferencesAsyncApi
    public void setBool(String key, boolean z7, SharedPreferencesPigeonOptions options) {
        AbstractC2304t.f(key, "key");
        AbstractC2304t.f(options, "options");
        AbstractC1007h.b(null, new C20481(key, this, z7, null), 1, null);
    }

    @Override // io.flutter.plugins.sharedpreferences.SharedPreferencesAsyncApi
    public void setDeprecatedStringList(String key, List<String> value, SharedPreferencesPigeonOptions options) {
        AbstractC2304t.f(key, "key");
        AbstractC2304t.f(value, "value");
        AbstractC2304t.f(options, "options");
        AbstractC1007h.b(null, new C20491(key, SharedPreferencesPluginKt.LIST_PREFIX + this.listEncoder.encode(value), null), 1, null);
    }

    @Override // io.flutter.plugins.sharedpreferences.SharedPreferencesAsyncApi
    public void setDouble(String key, double d8, SharedPreferencesPigeonOptions options) {
        AbstractC2304t.f(key, "key");
        AbstractC2304t.f(options, "options");
        AbstractC1007h.b(null, new C20501(key, this, d8, null), 1, null);
    }

    @Override // io.flutter.plugins.sharedpreferences.SharedPreferencesAsyncApi
    public void setEncodedStringList(String key, String value, SharedPreferencesPigeonOptions options) {
        AbstractC2304t.f(key, "key");
        AbstractC2304t.f(value, "value");
        AbstractC2304t.f(options, "options");
        AbstractC1007h.b(null, new C20511(key, value, null), 1, null);
    }

    @Override // io.flutter.plugins.sharedpreferences.SharedPreferencesAsyncApi
    public void setInt(String key, long j8, SharedPreferencesPigeonOptions options) {
        AbstractC2304t.f(key, "key");
        AbstractC2304t.f(options, "options");
        AbstractC1007h.b(null, new C20521(key, this, j8, null), 1, null);
    }

    @Override // io.flutter.plugins.sharedpreferences.SharedPreferencesAsyncApi
    public void setString(String key, String value, SharedPreferencesPigeonOptions options) {
        AbstractC2304t.f(key, "key");
        AbstractC2304t.f(value, "value");
        AbstractC2304t.f(options, "options");
        AbstractC1007h.b(null, new C20531(key, value, null), 1, null);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SharedPreferencesPlugin(SharedPreferencesListEncoder listEncoder) {
        this();
        AbstractC2304t.f(listEncoder, "listEncoder");
        this.listEncoder = listEncoder;
    }
}
