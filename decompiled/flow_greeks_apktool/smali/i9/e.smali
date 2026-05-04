.class public Li9/e;
.super Ljava/lang/Object;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"


# static fields
.field public static final c:Ljava/util/Comparator;

.field public static final d:Ljava/util/Comparator;


# instance fields
.field public final a:Lj9/k;

.field public final b:I


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .line 1
    new-instance v0, Li9/c;

    .line 2
    .line 3
    invoke-direct {v0}, Li9/c;-><init>()V

    .line 4
    .line 5
    .line 6
    sput-object v0, Li9/e;->c:Ljava/util/Comparator;

    .line 7
    .line 8
    new-instance v0, Li9/d;

    .line 9
    .line 10
    invoke-direct {v0}, Li9/d;-><init>()V

    .line 11
    .line 12
    .line 13
    sput-object v0, Li9/e;->d:Ljava/util/Comparator;

    .line 14
    .line 15
    return-void
    .line 16
.end method

.method public constructor <init>(Lj9/k;I)V
    .locals 0

    .line 1
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 2
    .line 3
    .line 4
    iput-object p1, p0, Li9/e;->a:Lj9/k;

    .line 5
    .line 6
    iput p2, p0, Li9/e;->b:I

    .line 7
    .line 8
    return-void
    .line 9
    .line 10
    .line 11
    .line 12
    .line 13
    .line 14
    .line 15
    .line 16
    .line 17
    .line 18
    .line 19
    .line 20
    .line 21
    .line 22
    .line 23
    .line 24
    .line 25
    .line 26
    .line 27
    .line 28
    .line 29
    .line 30
    .line 31
    .line 32
    .line 33
    .line 34
    .line 35
    .line 36
    .line 37
    .line 38
    .line 39
.end method

.method public static synthetic a(Li9/e;Li9/e;)I
    .locals 2

    .line 1
    iget v0, p0, Li9/e;->b:I

    .line 2
    .line 3
    iget v1, p1, Li9/e;->b:I

    .line 4
    .line 5
    invoke-static {v0, v1}, Ljava/lang/Integer;->compare(II)I

    .line 6
    .line 7
    .line 8
    move-result v0

    .line 9
    if-eqz v0, :cond_0

    .line 10
    .line 11
    return v0

    .line 12
    :cond_0
    iget-object p0, p0, Li9/e;->a:Lj9/k;

    .line 13
    .line 14
    iget-object p1, p1, Li9/e;->a:Lj9/k;

    .line 15
    .line 16
    invoke-virtual {p0, p1}, Lj9/k;->b(Lj9/k;)I

    .line 17
    .line 18
    .line 19
    move-result p0

    .line 20
    return p0
    .line 21
    .line 22
    .line 23
    .line 24
    .line 25
    .line 26
    .line 27
    .line 28
    .line 29
    .line 30
    .line 31
    .line 32
    .line 33
    .line 34
    .line 35
    .line 36
    .line 37
    .line 38
    .line 39
.end method

.method public static synthetic b(Li9/e;Li9/e;)I
    .locals 2

    .line 1
    iget-object v0, p0, Li9/e;->a:Lj9/k;

    .line 2
    .line 3
    iget-object v1, p1, Li9/e;->a:Lj9/k;

    .line 4
    .line 5
    invoke-virtual {v0, v1}, Lj9/k;->b(Lj9/k;)I

    .line 6
    .line 7
    .line 8
    move-result v0

    .line 9
    if-eqz v0, :cond_0

    .line 10
    .line 11
    return v0

    .line 12
    :cond_0
    iget p0, p0, Li9/e;->b:I

    .line 13
    .line 14
    iget p1, p1, Li9/e;->b:I

    .line 15
    .line 16
    invoke-static {p0, p1}, Ljava/lang/Integer;->compare(II)I

    .line 17
    .line 18
    .line 19
    move-result p0

    .line 20
    return p0
    .line 21
    .line 22
    .line 23
    .line 24
    .line 25
    .line 26
    .line 27
    .line 28
    .line 29
    .line 30
    .line 31
    .line 32
    .line 33
    .line 34
    .line 35
    .line 36
    .line 37
    .line 38
    .line 39
.end method


# virtual methods
.method public c()I
    .locals 1

    .line 1
    iget v0, p0, Li9/e;->b:I

    .line 2
    .line 3
    return v0
    .line 4
    .line 5
    .line 6
    .line 7
    .line 8
    .line 9
    .line 10
    .line 11
    .line 12
    .line 13
    .line 14
    .line 15
    .line 16
.end method

.method public d()Lj9/k;
    .locals 1

    .line 1
    iget-object v0, p0, Li9/e;->a:Lj9/k;

    .line 2
    .line 3
    return-object v0
    .line 4
    .line 5
    .line 6
    .line 7
    .line 8
    .line 9
    .line 10
    .line 11
    .line 12
    .line 13
    .line 14
    .line 15
    .line 16
.end method
