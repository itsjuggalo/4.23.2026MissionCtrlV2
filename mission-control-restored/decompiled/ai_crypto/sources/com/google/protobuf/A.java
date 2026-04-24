package com.google.protobuf;

import com.google.protobuf.AbstractC1255y;

/* JADX INFO: loaded from: classes.dex */
public final class A extends AbstractC1255y implements W {
    private static final A DEFAULT_INSTANCE;
    private static volatile f0 PARSER = null;
    public static final int VALUE_FIELD_NUMBER = 1;
    private long value_;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f12504a;

        static {
            int[] iArr = new int[AbstractC1255y.d.values().length];
            f12504a = iArr;
            try {
                iArr[AbstractC1255y.d.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f12504a[AbstractC1255y.d.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f12504a[AbstractC1255y.d.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f12504a[AbstractC1255y.d.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f12504a[AbstractC1255y.d.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f12504a[AbstractC1255y.d.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f12504a[AbstractC1255y.d.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public static final class b extends AbstractC1255y.a implements W {
        public /* synthetic */ b(a aVar) {
            this();
        }

        public b() {
            super(A.DEFAULT_INSTANCE);
        }
    }

    static {
        A a7 = new A();
        DEFAULT_INSTANCE = a7;
        AbstractC1255y.V(A.class, a7);
    }

    @Override // com.google.protobuf.AbstractC1255y
    public final Object y(AbstractC1255y.d dVar, Object obj, Object obj2) {
        a aVar = null;
        switch (a.f12504a[dVar.ordinal()]) {
            case 1:
                return new A();
            case 2:
                return new b(aVar);
            case 3:
                return AbstractC1255y.N(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u0002", new Object[]{"value_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                f0 bVar = PARSER;
                if (bVar == null) {
                    synchronized (A.class) {
                        try {
                            bVar = PARSER;
                            if (bVar == null) {
                                bVar = new AbstractC1255y.b(DEFAULT_INSTANCE);
                                PARSER = bVar;
                            }
                        } finally {
                        }
                        break;
                    }
                }
                return bVar;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }
}
