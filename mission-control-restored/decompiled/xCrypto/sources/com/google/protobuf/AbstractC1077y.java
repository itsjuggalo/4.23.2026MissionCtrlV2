package com.google.protobuf;

import com.google.protobuf.AbstractC1050a;
import com.google.protobuf.AbstractC1059f;
import com.google.protobuf.C;
import com.google.protobuf.C0;
import com.google.protobuf.C1073u;
import com.google.protobuf.W;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: renamed from: com.google.protobuf.y, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1077y extends AbstractC1050a {
    private static final int MEMOIZED_SERIALIZED_SIZE_MASK = Integer.MAX_VALUE;
    private static final int MUTABLE_FLAG_MASK = Integer.MIN_VALUE;
    static final int UNINITIALIZED_HASH_CODE = 0;
    static final int UNINITIALIZED_SERIALIZED_SIZE = Integer.MAX_VALUE;
    private static Map<Object, AbstractC1077y> defaultInstanceMap = new ConcurrentHashMap();
    private int memoizedSerializedSize = -1;
    protected x0 unknownFields = x0.c();

    /* JADX INFO: renamed from: com.google.protobuf.y$a */
    public static abstract class a extends AbstractC1050a.AbstractC0158a {
        private final AbstractC1077y defaultInstance;
        protected AbstractC1077y instance;

        public a(AbstractC1077y abstractC1077y) {
            this.defaultInstance = abstractC1077y;
            if (abstractC1077y.isMutable()) {
                throw new IllegalArgumentException("Default instance must be immutable.");
            }
            this.instance = e();
        }

        public static void d(Object obj, Object obj2) {
            j0.a().d(obj).a(obj, obj2);
        }

        private AbstractC1077y e() {
            return this.defaultInstance.newMutableInstance();
        }

        public final void copyOnWrite() {
            if (this.instance.isMutable()) {
                return;
            }
            copyOnWriteInternal();
        }

        public void copyOnWriteInternal() {
            AbstractC1077y abstractC1077yE = e();
            d(abstractC1077yE, this.instance);
            this.instance = abstractC1077yE;
        }

        @Override // com.google.protobuf.X
        public final boolean isInitialized() {
            return AbstractC1077y.isInitialized(this.instance, false);
        }

        @Override // com.google.protobuf.W.a
        public final AbstractC1077y build() {
            AbstractC1077y abstractC1077yBuildPartial = buildPartial();
            if (abstractC1077yBuildPartial.isInitialized()) {
                return abstractC1077yBuildPartial;
            }
            throw AbstractC1050a.AbstractC0158a.newUninitializedMessageException(abstractC1077yBuildPartial);
        }

        @Override // com.google.protobuf.W.a
        public AbstractC1077y buildPartial() {
            if (!this.instance.isMutable()) {
                return this.instance;
            }
            this.instance.makeImmutable();
            return this.instance;
        }

        public final a clear() {
            if (this.defaultInstance.isMutable()) {
                throw new IllegalArgumentException("Default instance must be immutable.");
            }
            this.instance = e();
            return this;
        }

        @Override // com.google.protobuf.X
        public AbstractC1077y getDefaultInstanceForType() {
            return this.defaultInstance;
        }

        @Override // com.google.protobuf.AbstractC1050a.AbstractC0158a
        public a internalMergeFrom(AbstractC1077y abstractC1077y) {
            return mergeFrom(abstractC1077y);
        }

        /* JADX INFO: renamed from: clone, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public a m33clone() {
            a aVarNewBuilderForType = getDefaultInstanceForType().newBuilderForType();
            aVarNewBuilderForType.instance = buildPartial();
            return aVarNewBuilderForType;
        }

        public a mergeFrom(AbstractC1077y abstractC1077y) {
            if (getDefaultInstanceForType().equals(abstractC1077y)) {
                return this;
            }
            copyOnWrite();
            d(this.instance, abstractC1077y);
            return this;
        }

        @Override // com.google.protobuf.AbstractC1050a.AbstractC0158a
        public a mergeFrom(byte[] bArr, int i4, int i5, C1070q c1070q) throws D {
            copyOnWrite();
            try {
                j0.a().d(this.instance).j(this.instance, bArr, i4, i4 + i5, new AbstractC1059f.a(c1070q));
                return this;
            } catch (D e4) {
                throw e4;
            } catch (IOException e5) {
                throw new RuntimeException("Reading from byte array should not throw IOException.", e5);
            } catch (IndexOutOfBoundsException unused) {
                throw D.m();
            }
        }

        @Override // com.google.protobuf.AbstractC1050a.AbstractC0158a
        public a mergeFrom(byte[] bArr, int i4, int i5) {
            return mergeFrom(bArr, i4, i5, C1070q.b());
        }

        @Override // com.google.protobuf.AbstractC1050a.AbstractC0158a, com.google.protobuf.W.a
        public a mergeFrom(AbstractC1063j abstractC1063j, C1070q c1070q) throws IOException {
            copyOnWrite();
            try {
                j0.a().d(this.instance).i(this.instance, C1064k.Q(abstractC1063j), c1070q);
                return this;
            } catch (RuntimeException e4) {
                if (e4.getCause() instanceof IOException) {
                    throw ((IOException) e4.getCause());
                }
                throw e4;
            }
        }
    }

    /* JADX INFO: renamed from: com.google.protobuf.y$b */
    public static class b extends AbstractC1052b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final AbstractC1077y f11255b;

        public b(AbstractC1077y abstractC1077y) {
            this.f11255b = abstractC1077y;
        }

        @Override // com.google.protobuf.g0
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public AbstractC1077y b(AbstractC1063j abstractC1063j, C1070q c1070q) {
            return AbstractC1077y.parsePartialFrom(this.f11255b, abstractC1063j, c1070q);
        }
    }

    /* JADX INFO: renamed from: com.google.protobuf.y$c */
    public static final class c implements C1073u.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final C.d f11256a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f11257b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final C0.b f11258c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f11259d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final boolean f11260e;

        public c(C.d dVar, int i4, C0.b bVar, boolean z4, boolean z5) {
            this.f11256a = dVar;
            this.f11257b = i4;
            this.f11258c = bVar;
            this.f11259d = z4;
            this.f11260e = z5;
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(c cVar) {
            return this.f11257b - cVar.f11257b;
        }

        @Override // com.google.protobuf.C1073u.b
        public W.a b(W.a aVar, W w4) {
            return ((a) aVar).mergeFrom((AbstractC1077y) w4);
        }

        public C.d c() {
            return this.f11256a;
        }

        @Override // com.google.protobuf.C1073u.b
        public boolean d() {
            return this.f11259d;
        }

        @Override // com.google.protobuf.C1073u.b
        public C0.b e() {
            return this.f11258c;
        }

        @Override // com.google.protobuf.C1073u.b
        public boolean f() {
            return this.f11260e;
        }

        @Override // com.google.protobuf.C1073u.b
        public int getNumber() {
            return this.f11257b;
        }

        @Override // com.google.protobuf.C1073u.b
        public C0.c j() {
            return this.f11258c.a();
        }
    }

    /* JADX INFO: renamed from: com.google.protobuf.y$d */
    public static class d extends AbstractC1068o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final W f11261a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Object f11262b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final W f11263c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final c f11264d;

        public d(W w4, Object obj, W w5, c cVar, Class cls) {
            if (w4 == null) {
                throw new IllegalArgumentException("Null containingTypeDefaultInstance");
            }
            if (cVar.e() == C0.b.f10901m && w5 == null) {
                throw new IllegalArgumentException("Null messageDefaultInstance");
            }
            this.f11261a = w4;
            this.f11262b = obj;
            this.f11263c = w5;
            this.f11264d = cVar;
        }

        public C0.b b() {
            return this.f11264d.e();
        }

        public W c() {
            return this.f11263c;
        }

        public int d() {
            return this.f11264d.getNumber();
        }

        public boolean e() {
            return this.f11264d.f11259d;
        }
    }

    /* JADX INFO: renamed from: com.google.protobuf.y$e */
    public enum e {
        GET_MEMOIZED_IS_INITIALIZED,
        SET_MEMOIZED_IS_INITIALIZED,
        BUILD_MESSAGE_INFO,
        NEW_MUTABLE_INSTANCE,
        NEW_BUILDER,
        GET_DEFAULT_INSTANCE,
        GET_PARSER
    }

    public static d c(AbstractC1068o abstractC1068o) {
        if (abstractC1068o.a()) {
            return (d) abstractC1068o;
        }
        throw new IllegalArgumentException("Expected a lite extension.");
    }

    public static AbstractC1077y d(AbstractC1077y abstractC1077y) throws D {
        if (abstractC1077y == null || abstractC1077y.isInitialized()) {
            return abstractC1077y;
        }
        throw abstractC1077y.newUninitializedMessageException().a().k(abstractC1077y);
    }

    public static C.a emptyBooleanList() {
        return C1060g.m();
    }

    public static C.b emptyDoubleList() {
        return C1067n.m();
    }

    public static C.f emptyFloatList() {
        return C1075w.m();
    }

    public static C.g emptyIntList() {
        return B.m();
    }

    public static C.h emptyLongList() {
        return M.m();
    }

    public static <E> C.i emptyProtobufList() {
        return k0.i();
    }

    public static AbstractC1077y g(AbstractC1077y abstractC1077y, InputStream inputStream, C1070q c1070q) throws D {
        try {
            int i4 = inputStream.read();
            if (i4 == -1) {
                return null;
            }
            AbstractC1063j abstractC1063jG = AbstractC1063j.g(new AbstractC1050a.AbstractC0158a.C0159a(inputStream, AbstractC1063j.z(i4, inputStream)));
            AbstractC1077y partialFrom = parsePartialFrom(abstractC1077y, abstractC1063jG, c1070q);
            try {
                abstractC1063jG.a(0);
                return partialFrom;
            } catch (D e4) {
                throw e4.k(partialFrom);
            }
        } catch (D e5) {
            if (e5.a()) {
                throw new D(e5);
            }
            throw e5;
        } catch (IOException e6) {
            throw new D(e6);
        }
    }

    public static <T extends AbstractC1077y> T getDefaultInstance(Class<T> cls) {
        T t4 = (T) defaultInstanceMap.get(cls);
        if (t4 == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                t4 = (T) defaultInstanceMap.get(cls);
            } catch (ClassNotFoundException e4) {
                throw new IllegalStateException("Class initialization cannot fail.", e4);
            }
        }
        if (t4 != null) {
            return t4;
        }
        T t5 = (T) ((AbstractC1077y) A0.l(cls)).getDefaultInstanceForType();
        if (t5 == null) {
            throw new IllegalStateException();
        }
        defaultInstanceMap.put(cls, t5);
        return t5;
    }

    public static Method getMethodOrDie(Class cls, String str, Class... clsArr) {
        try {
            return cls.getMethod(str, clsArr);
        } catch (NoSuchMethodException e4) {
            throw new RuntimeException("Generated message class \"" + cls.getName() + "\" missing method \"" + str + "\".", e4);
        }
    }

    public static AbstractC1077y h(AbstractC1077y abstractC1077y, AbstractC1062i abstractC1062i, C1070q c1070q) throws D {
        AbstractC1063j abstractC1063jA = abstractC1062i.A();
        AbstractC1077y partialFrom = parsePartialFrom(abstractC1077y, abstractC1063jA, c1070q);
        try {
            abstractC1063jA.a(0);
            return partialFrom;
        } catch (D e4) {
            throw e4.k(partialFrom);
        }
    }

    public static AbstractC1077y i(AbstractC1077y abstractC1077y, byte[] bArr, int i4, int i5, C1070q c1070q) throws D {
        AbstractC1077y abstractC1077yNewMutableInstance = abstractC1077y.newMutableInstance();
        try {
            o0 o0VarD = j0.a().d(abstractC1077yNewMutableInstance);
            o0VarD.j(abstractC1077yNewMutableInstance, bArr, i4, i4 + i5, new AbstractC1059f.a(c1070q));
            o0VarD.b(abstractC1077yNewMutableInstance);
            return abstractC1077yNewMutableInstance;
        } catch (D e4) {
            D d4 = e4;
            if (d4.a()) {
                d4 = new D(d4);
            }
            throw d4.k(abstractC1077yNewMutableInstance);
        } catch (v0 e5) {
            throw e5.a().k(abstractC1077yNewMutableInstance);
        } catch (IOException e6) {
            if (e6.getCause() instanceof D) {
                throw ((D) e6.getCause());
            }
            throw new D(e6).k(abstractC1077yNewMutableInstance);
        } catch (IndexOutOfBoundsException unused) {
            throw D.m().k(abstractC1077yNewMutableInstance);
        }
    }

    public static Object invokeOrDie(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e4) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e4);
        } catch (InvocationTargetException e5) {
            Throwable cause = e5.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            if (cause instanceof Error) {
                throw ((Error) cause);
            }
            throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
        }
    }

    public static C.g mutableCopy(C.g gVar) {
        int size = gVar.size();
        return gVar.a(size == 0 ? 10 : size * 2);
    }

    public static Object newMessageInfo(W w4, String str, Object[] objArr) {
        return new l0(w4, str, objArr);
    }

    public static <ContainingType extends W, Type> d newRepeatedGeneratedExtension(ContainingType containingtype, W w4, C.d dVar, int i4, C0.b bVar, boolean z4, Class cls) {
        return new d(containingtype, Collections.EMPTY_LIST, w4, new c(dVar, i4, bVar, true, z4), cls);
    }

    public static <ContainingType extends W, Type> d newSingularGeneratedExtension(ContainingType containingtype, Type type, W w4, C.d dVar, int i4, C0.b bVar, Class cls) {
        return new d(containingtype, type, w4, new c(dVar, i4, bVar, false, false), cls);
    }

    public static <T extends AbstractC1077y> T parseDelimitedFrom(T t4, InputStream inputStream) {
        return (T) d(g(t4, inputStream, C1070q.b()));
    }

    public static <T extends AbstractC1077y> T parseFrom(T t4, ByteBuffer byteBuffer, C1070q c1070q) {
        return (T) d(parseFrom(t4, AbstractC1063j.j(byteBuffer), c1070q));
    }

    public static <T extends AbstractC1077y> T parsePartialFrom(T t4, AbstractC1063j abstractC1063j, C1070q c1070q) throws D {
        T t5 = (T) t4.newMutableInstance();
        try {
            o0 o0VarD = j0.a().d(t5);
            o0VarD.i(t5, C1064k.Q(abstractC1063j), c1070q);
            o0VarD.b(t5);
            return t5;
        } catch (D e4) {
            e = e4;
            if (e.a()) {
                e = new D(e);
            }
            throw e.k(t5);
        } catch (v0 e5) {
            throw e5.a().k(t5);
        } catch (IOException e6) {
            if (e6.getCause() instanceof D) {
                throw ((D) e6.getCause());
            }
            throw new D(e6).k(t5);
        } catch (RuntimeException e7) {
            if (e7.getCause() instanceof D) {
                throw ((D) e7.getCause());
            }
            throw e7;
        }
    }

    public static <T extends AbstractC1077y> void registerDefaultInstance(Class<T> cls, T t4) {
        t4.markImmutable();
        defaultInstanceMap.put(cls, t4);
    }

    public Object buildMessageInfo() {
        return dynamicMethod(e.BUILD_MESSAGE_INFO);
    }

    public void clearMemoizedHashCode() {
        this.memoizedHashCode = 0;
    }

    public void clearMemoizedSerializedSize() {
        setMemoizedSerializedSize(Integer.MAX_VALUE);
    }

    public int computeHashCode() {
        return j0.a().d(this).g(this);
    }

    public final <MessageType extends AbstractC1077y, BuilderType extends a> BuilderType createBuilder() {
        return (BuilderType) dynamicMethod(e.NEW_BUILDER);
    }

    public Object dynamicMethod(e eVar, Object obj) {
        return dynamicMethod(eVar, obj, null);
    }

    public abstract Object dynamicMethod(e eVar, Object obj, Object obj2);

    public final int e(o0 o0Var) {
        return o0Var == null ? j0.a().d(this).e(this) : o0Var.e(this);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return j0.a().d(this).d(this, (AbstractC1077y) obj);
        }
        return false;
    }

    public final void f() {
        if (this.unknownFields == x0.c()) {
            this.unknownFields = x0.o();
        }
    }

    public int getMemoizedHashCode() {
        return this.memoizedHashCode;
    }

    public int getMemoizedSerializedSize() {
        return this.memoizedSerializedSize & Integer.MAX_VALUE;
    }

    @Override // com.google.protobuf.W
    public final g0 getParserForType() {
        return (g0) dynamicMethod(e.GET_PARSER);
    }

    @Override // com.google.protobuf.AbstractC1050a
    public int getSerializedSize(o0 o0Var) {
        if (!isMutable()) {
            if (getMemoizedSerializedSize() != Integer.MAX_VALUE) {
                return getMemoizedSerializedSize();
            }
            int iE = e(o0Var);
            setMemoizedSerializedSize(iE);
            return iE;
        }
        int iE2 = e(o0Var);
        if (iE2 >= 0) {
            return iE2;
        }
        throw new IllegalStateException("serialized size must be non-negative, was " + iE2);
    }

    public int hashCode() {
        if (isMutable()) {
            return computeHashCode();
        }
        if (hashCodeIsNotMemoized()) {
            setMemoizedHashCode(computeHashCode());
        }
        return getMemoizedHashCode();
    }

    public boolean hashCodeIsNotMemoized() {
        return getMemoizedHashCode() == 0;
    }

    @Override // com.google.protobuf.X
    public final boolean isInitialized() {
        return isInitialized(this, true);
    }

    public boolean isMutable() {
        return (this.memoizedSerializedSize & MUTABLE_FLAG_MASK) != 0;
    }

    public void makeImmutable() {
        j0.a().d(this).b(this);
        markImmutable();
    }

    public void markImmutable() {
        this.memoizedSerializedSize &= Integer.MAX_VALUE;
    }

    public void mergeLengthDelimitedField(int i4, AbstractC1062i abstractC1062i) {
        f();
        this.unknownFields.l(i4, abstractC1062i);
    }

    public final void mergeUnknownFields(x0 x0Var) {
        this.unknownFields = x0.n(this.unknownFields, x0Var);
    }

    public void mergeVarintField(int i4, int i5) {
        f();
        this.unknownFields.m(i4, i5);
    }

    public AbstractC1077y newMutableInstance() {
        return (AbstractC1077y) dynamicMethod(e.NEW_MUTABLE_INSTANCE);
    }

    public boolean parseUnknownField(int i4, AbstractC1063j abstractC1063j) {
        if (C0.b(i4) == 4) {
            return false;
        }
        f();
        return this.unknownFields.i(i4, abstractC1063j);
    }

    public void setMemoizedHashCode(int i4) {
        this.memoizedHashCode = i4;
    }

    public void setMemoizedSerializedSize(int i4) {
        if (i4 >= 0) {
            this.memoizedSerializedSize = (i4 & Integer.MAX_VALUE) | (this.memoizedSerializedSize & MUTABLE_FLAG_MASK);
        } else {
            throw new IllegalStateException("serialized size must be non-negative, was " + i4);
        }
    }

    public String toString() {
        return Y.f(this, super.toString());
    }

    @Override // com.google.protobuf.W
    public void writeTo(AbstractC1065l abstractC1065l) {
        j0.a().d(this).h(this, C1066m.P(abstractC1065l));
    }

    public static final <T extends AbstractC1077y> boolean isInitialized(T t4, boolean z4) {
        byte bByteValue = ((Byte) t4.dynamicMethod(e.GET_MEMOIZED_IS_INITIALIZED)).byteValue();
        if (bByteValue == 1) {
            return true;
        }
        if (bByteValue == 0) {
            return false;
        }
        boolean zC = j0.a().d(t4).c(t4);
        if (z4) {
            t4.dynamicMethod(e.SET_MEMOIZED_IS_INITIALIZED, zC ? t4 : null);
        }
        return zC;
    }

    public final <MessageType extends AbstractC1077y, BuilderType extends a> BuilderType createBuilder(MessageType messagetype) {
        return (BuilderType) createBuilder().mergeFrom((AbstractC1077y) messagetype);
    }

    public Object dynamicMethod(e eVar) {
        return dynamicMethod(eVar, null, null);
    }

    @Override // com.google.protobuf.X
    public final AbstractC1077y getDefaultInstanceForType() {
        return (AbstractC1077y) dynamicMethod(e.GET_DEFAULT_INSTANCE);
    }

    @Override // com.google.protobuf.W
    public final a newBuilderForType() {
        return (a) dynamicMethod(e.NEW_BUILDER);
    }

    @Override // com.google.protobuf.W
    public final a toBuilder() {
        return ((a) dynamicMethod(e.NEW_BUILDER)).mergeFrom(this);
    }

    public static C.h mutableCopy(C.h hVar) {
        int size = hVar.size();
        return hVar.a(size == 0 ? 10 : size * 2);
    }

    public static <T extends AbstractC1077y> T parseFrom(T t4, ByteBuffer byteBuffer) {
        return (T) parseFrom(t4, byteBuffer, C1070q.b());
    }

    public static <T extends AbstractC1077y> T parseDelimitedFrom(T t4, InputStream inputStream, C1070q c1070q) {
        return (T) d(g(t4, inputStream, c1070q));
    }

    public static <T extends AbstractC1077y> T parseFrom(T t4, AbstractC1062i abstractC1062i) {
        return (T) d(parseFrom(t4, abstractC1062i, C1070q.b()));
    }

    public static C.f mutableCopy(C.f fVar) {
        int size = fVar.size();
        return fVar.a(size == 0 ? 10 : size * 2);
    }

    public static <T extends AbstractC1077y> T parseFrom(T t4, AbstractC1062i abstractC1062i, C1070q c1070q) {
        return (T) d(h(t4, abstractC1062i, c1070q));
    }

    public static C.b mutableCopy(C.b bVar) {
        int size = bVar.size();
        return bVar.a(size == 0 ? 10 : size * 2);
    }

    public static <T extends AbstractC1077y> T parseFrom(T t4, byte[] bArr) {
        return (T) d(i(t4, bArr, 0, bArr.length, C1070q.b()));
    }

    @Override // com.google.protobuf.W
    public int getSerializedSize() {
        return getSerializedSize(null);
    }

    public static C.a mutableCopy(C.a aVar) {
        int size = aVar.size();
        return aVar.a(size == 0 ? 10 : size * 2);
    }

    public static <T extends AbstractC1077y> T parseFrom(T t4, byte[] bArr, C1070q c1070q) {
        return (T) d(i(t4, bArr, 0, bArr.length, c1070q));
    }

    public static <E> C.i mutableCopy(C.i iVar) {
        int size = iVar.size();
        return iVar.a(size == 0 ? 10 : size * 2);
    }

    public static <T extends AbstractC1077y> T parseFrom(T t4, InputStream inputStream) {
        return (T) d(parsePartialFrom(t4, AbstractC1063j.g(inputStream), C1070q.b()));
    }

    public static <T extends AbstractC1077y> T parsePartialFrom(T t4, AbstractC1063j abstractC1063j) {
        return (T) parsePartialFrom(t4, abstractC1063j, C1070q.b());
    }

    public static <T extends AbstractC1077y> T parseFrom(T t4, InputStream inputStream, C1070q c1070q) {
        return (T) d(parsePartialFrom(t4, AbstractC1063j.g(inputStream), c1070q));
    }

    public static <T extends AbstractC1077y> T parseFrom(T t4, AbstractC1063j abstractC1063j) {
        return (T) parseFrom(t4, abstractC1063j, C1070q.b());
    }

    public static <T extends AbstractC1077y> T parseFrom(T t4, AbstractC1063j abstractC1063j, C1070q c1070q) {
        return (T) d(parsePartialFrom(t4, abstractC1063j, c1070q));
    }
}
