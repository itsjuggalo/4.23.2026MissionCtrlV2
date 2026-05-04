.class public Lx6/a$d;
.super Ljava/lang/Object;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lx6/a;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "d"
.end annotation


# instance fields
.field public final a:[J

.field public final b:[J

.field public final c:[J


# direct methods
.method public constructor <init>()V
    .locals 3

    const/16 v0, 0xa

    .line 1
    new-array v1, v0, [J

    new-array v2, v0, [J

    new-array v0, v0, [J

    invoke-direct {p0, v1, v2, v0}, Lx6/a$d;-><init>([J[J[J)V

    return-void
.end method

.method public constructor <init>(Lx6/a$c;)V
    .locals 0

    .line 10
    invoke-direct {p0}, Lx6/a$d;-><init>()V

    .line 11
    invoke-static {p0, p1}, Lx6/a$d;->a(Lx6/a$d;Lx6/a$c;)Lx6/a$d;

    return-void
.end method

.method public constructor <init>(Lx6/a$d;)V
    .locals 2

    .line 6
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 7
    iget-object v0, p1, Lx6/a$d;->a:[J

    const/16 v1, 0xa

    invoke-static {v0, v1}, Ljava/util/Arrays;->copyOf([JI)[J

    move-result-object v0

    iput-object v0, p0, Lx6/a$d;->a:[J

    .line 8
    iget-object v0, p1, Lx6/a$d;->b:[J

    invoke-static {v0, v1}, Ljava/util/Arrays;->copyOf([JI)[J

    move-result-object v0

    iput-object v0, p0, Lx6/a$d;->b:[J

    .line 9
    iget-object p1, p1, Lx6/a$d;->c:[J

    invoke-static {p1, v1}, Ljava/util/Arrays;->copyOf([JI)[J

    move-result-object p1

    iput-object p1, p0, Lx6/a$d;->c:[J

    return-void
.end method

.method public constructor <init>([J[J[J)V
    .locals 0

    .line 2
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 3
    iput-object p1, p0, Lx6/a$d;->a:[J

    .line 4
    iput-object p2, p0, Lx6/a$d;->b:[J

    .line 5
    iput-object p3, p0, Lx6/a$d;->c:[J

    return-void
.end method

.method public static a(Lx6/a$d;Lx6/a$c;)Lx6/a$d;
    .locals 3

    .line 1
    iget-object v0, p0, Lx6/a$d;->a:[J

    .line 2
    .line 3
    iget-object v1, p1, Lx6/a$c;->a:Lx6/a$d;

    .line 4
    .line 5
    iget-object v1, v1, Lx6/a$d;->a:[J

    .line 6
    .line 7
    iget-object v2, p1, Lx6/a$c;->b:[J

    .line 8
    .line 9
    invoke-static {v0, v1, v2}, Lx6/f;->f([J[J[J)V

    .line 10
    .line 11
    .line 12
    iget-object v0, p0, Lx6/a$d;->b:[J

    .line 13
    .line 14
    iget-object v1, p1, Lx6/a$c;->a:Lx6/a$d;

    .line 15
    .line 16
    iget-object v2, v1, Lx6/a$d;->b:[J

    .line 17
    .line 18
    iget-object v1, v1, Lx6/a$d;->c:[J

    .line 19
    .line 20
    invoke-static {v0, v2, v1}, Lx6/f;->f([J[J[J)V

    .line 21
    .line 22
    .line 23
    iget-object v0, p0, Lx6/a$d;->c:[J

    .line 24
    .line 25
    iget-object v1, p1, Lx6/a$c;->a:Lx6/a$d;

    .line 26
    .line 27
    iget-object v1, v1, Lx6/a$d;->c:[J

    .line 28
    .line 29
    iget-object p1, p1, Lx6/a$c;->b:[J

    .line 30
    .line 31
    invoke-static {v0, v1, p1}, Lx6/f;->f([J[J[J)V

    .line 32
    .line 33
    .line 34
    return-object p0
    .line 35
    .line 36
    .line 37
    .line 38
    .line 39
.end method


# virtual methods
.method public b()[B
    .locals 4

    .line 1
    const/16 v0, 0xa

    .line 2
    .line 3
    new-array v1, v0, [J

    .line 4
    .line 5
    new-array v2, v0, [J

    .line 6
    .line 7
    new-array v0, v0, [J

    .line 8
    .line 9
    iget-object v3, p0, Lx6/a$d;->c:[J

    .line 10
    .line 11
    invoke-static {v1, v3}, Lx6/f;->e([J[J)V

    .line 12
    .line 13
    .line 14
    iget-object v3, p0, Lx6/a$d;->a:[J

    .line 15
    .line 16
    invoke-static {v2, v3, v1}, Lx6/f;->f([J[J[J)V

    .line 17
    .line 18
    .line 19
    iget-object v3, p0, Lx6/a$d;->b:[J

    .line 20
    .line 21
    invoke-static {v0, v3, v1}, Lx6/f;->f([J[J[J)V

    .line 22
    .line 23
    .line 24
    invoke-static {v0}, Lx6/f;->a([J)[B

    .line 25
    .line 26
    .line 27
    move-result-object v0

    .line 28
    const/16 v1, 0x1f

    .line 29
    .line 30
    aget-byte v3, v0, v1

    .line 31
    .line 32
    invoke-static {v2}, Lx6/a;->a([J)I

    .line 33
    .line 34
    .line 35
    move-result v2

    .line 36
    shl-int/lit8 v2, v2, 0x7

    .line 37
    .line 38
    xor-int/2addr v2, v3

    .line 39
    int-to-byte v2, v2

    .line 40
    aput-byte v2, v0, v1

    .line 41
    .line 42
    return-object v0
    .line 43
    .line 44
    .line 45
    .line 46
    .line 47
    .line 48
    .line 49
    .line 50
    .line 51
    .line 52
    .line 53
    .line 54
    .line 55
    .line 56
    .line 57
    .line 58
    .line 59
    .line 60
    .line 61
.end method
