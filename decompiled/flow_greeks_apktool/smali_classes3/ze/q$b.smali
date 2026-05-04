.class public final Lze/q$b;
.super Lgf/i;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"

# interfaces
.implements Lgf/q;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lze/q;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "b"
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lze/q$b$b;,
        Lze/q$b$c;
    }
.end annotation


# static fields
.field public static final i:Lze/q$b;

.field public static j:Lgf/r;


# instance fields
.field public final b:Lgf/d;

.field public c:I

.field public d:Lze/q$b$c;

.field public e:Lze/q;

.field public f:I

.field public g:B

.field public h:I


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .line 1
    new-instance v0, Lze/q$b$a;

    .line 2
    .line 3
    invoke-direct {v0}, Lze/q$b$a;-><init>()V

    .line 4
    .line 5
    .line 6
    sput-object v0, Lze/q$b;->j:Lgf/r;

    .line 7
    .line 8
    new-instance v0, Lze/q$b;

    .line 9
    .line 10
    const/4 v1, 0x1

    .line 11
    invoke-direct {v0, v1}, Lze/q$b;-><init>(Z)V

    .line 12
    .line 13
    .line 14
    sput-object v0, Lze/q$b;->i:Lze/q$b;

    .line 15
    .line 16
    invoke-direct {v0}, Lze/q$b;->D()V

    .line 17
    .line 18
    .line 19
    return-void
.end method

.method public constructor <init>(Lgf/e;Lgf/g;)V
    .locals 7

    .line 11
    invoke-direct {p0}, Lgf/i;-><init>()V

    const/4 v0, -0x1

    .line 12
    iput-byte v0, p0, Lze/q$b;->g:B

    .line 13
    iput v0, p0, Lze/q$b;->h:I

    .line 14
    invoke-direct {p0}, Lze/q$b;->D()V

    .line 15
    invoke-static {}, Lgf/d;->v()Lgf/d$b;

    move-result-object v0

    const/4 v1, 0x1

    .line 16
    invoke-static {v0, v1}, Lgf/f;->I(Ljava/io/OutputStream;I)Lgf/f;

    move-result-object v2

    const/4 v3, 0x0

    :cond_0
    :goto_0
    if-nez v3, :cond_8

    .line 17
    :try_start_0
    invoke-virtual {p1}, Lgf/e;->J()I

    move-result v4

    if-eqz v4, :cond_1

    const/16 v5, 0x8

    if-eq v4, v5, :cond_6

    const/16 v5, 0x12

    if-eq v4, v5, :cond_3

    const/16 v5, 0x18

    if-eq v4, v5, :cond_2

    .line 18
    invoke-virtual {p0, p1, v2, p2, v4}, Lgf/i;->o(Lgf/e;Lgf/f;Lgf/g;I)Z

    move-result v4

    if-nez v4, :cond_0

    :cond_1
    move v3, v1

    goto :goto_0

    :catchall_0
    move-exception p1

    goto :goto_4

    :catch_0
    move-exception p1

    goto :goto_2

    :catch_1
    move-exception p1

    goto :goto_3

    .line 19
    :cond_2
    iget v4, p0, Lze/q$b;->c:I

    or-int/lit8 v4, v4, 0x4

    iput v4, p0, Lze/q$b;->c:I

    .line 20
    invoke-virtual {p1}, Lgf/e;->r()I

    move-result v4

    iput v4, p0, Lze/q$b;->f:I

    goto :goto_0

    .line 21
    :cond_3
    iget v4, p0, Lze/q$b;->c:I

    const/4 v5, 0x2

    and-int/2addr v4, v5

    if-ne v4, v5, :cond_4

    .line 22
    iget-object v4, p0, Lze/q$b;->e:Lze/q;

    invoke-virtual {v4}, Lze/q;->A0()Lze/q$c;

    move-result-object v4

    goto :goto_1

    :cond_4
    const/4 v4, 0x0

    .line 23
    :goto_1
    sget-object v6, Lze/q;->v:Lgf/r;

    invoke-virtual {p1, v6, p2}, Lgf/e;->t(Lgf/r;Lgf/g;)Lgf/p;

    move-result-object v6

    check-cast v6, Lze/q;

    iput-object v6, p0, Lze/q$b;->e:Lze/q;

    if-eqz v4, :cond_5

    .line 24
    invoke-virtual {v4, v6}, Lze/q$c;->A(Lze/q;)Lze/q$c;

    .line 25
    invoke-virtual {v4}, Lze/q$c;->r()Lze/q;

    move-result-object v4

    iput-object v4, p0, Lze/q$b;->e:Lze/q;

    .line 26
    :cond_5
    iget v4, p0, Lze/q$b;->c:I

    or-int/2addr v4, v5

    iput v4, p0, Lze/q$b;->c:I

    goto :goto_0

    .line 27
    :cond_6
    invoke-virtual {p1}, Lgf/e;->m()I

    move-result v5

    .line 28
    invoke-static {v5}, Lze/q$b$c;->a(I)Lze/q$b$c;

    move-result-object v6

    if-nez v6, :cond_7

    .line 29
    invoke-virtual {v2, v4}, Lgf/f;->n0(I)V

    .line 30
    invoke-virtual {v2, v5}, Lgf/f;->n0(I)V

    goto :goto_0

    .line 31
    :cond_7
    iget v4, p0, Lze/q$b;->c:I

    or-int/2addr v4, v1

    iput v4, p0, Lze/q$b;->c:I

    .line 32
    iput-object v6, p0, Lze/q$b;->d:Lze/q$b$c;
    :try_end_0
    .catch Lgf/k; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_0

    .line 33
    :goto_2
    :try_start_1
    new-instance p2, Lgf/k;

    .line 34
    invoke-virtual {p1}, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;

    move-result-object p1

    invoke-direct {p2, p1}, Lgf/k;-><init>(Ljava/lang/String;)V

    invoke-virtual {p2, p0}, Lgf/k;->i(Lgf/p;)Lgf/k;

    move-result-object p1

    throw p1

    .line 35
    :goto_3
    invoke-virtual {p1, p0}, Lgf/k;->i(Lgf/p;)Lgf/k;

    move-result-object p1

    throw p1
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 36
    :goto_4
    :try_start_2
    invoke-virtual {v2}, Lgf/f;->H()V
    :try_end_2
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    .line 37
    :catch_2
    invoke-virtual {v0}, Lgf/d$b;->u()Lgf/d;

    move-result-object p2

    iput-object p2, p0, Lze/q$b;->b:Lgf/d;

    goto :goto_5

    :catchall_1
    move-exception p1

    invoke-virtual {v0}, Lgf/d$b;->u()Lgf/d;

    move-result-object p2

    iput-object p2, p0, Lze/q$b;->b:Lgf/d;

    .line 38
    throw p1

    .line 39
    :goto_5
    invoke-virtual {p0}, Lgf/i;->l()V

    .line 40
    throw p1

    .line 41
    :cond_8
    :try_start_3
    invoke-virtual {v2}, Lgf/f;->H()V
    :try_end_3
    .catch Ljava/io/IOException; {:try_start_3 .. :try_end_3} :catch_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_2

    .line 42
    :catch_3
    invoke-virtual {v0}, Lgf/d$b;->u()Lgf/d;

    move-result-object p1

    iput-object p1, p0, Lze/q$b;->b:Lgf/d;

    goto :goto_6

    :catchall_2
    move-exception p1

    invoke-virtual {v0}, Lgf/d$b;->u()Lgf/d;

    move-result-object p2

    iput-object p2, p0, Lze/q$b;->b:Lgf/d;

    .line 43
    throw p1

    .line 44
    :goto_6
    invoke-virtual {p0}, Lgf/i;->l()V

    return-void
.end method

.method public synthetic constructor <init>(Lgf/e;Lgf/g;Lze/a;)V
    .locals 0

    .line 1
    invoke-direct {p0, p1, p2}, Lze/q$b;-><init>(Lgf/e;Lgf/g;)V

    return-void
.end method

.method public constructor <init>(Lgf/i$b;)V
    .locals 1

    .line 3
    invoke-direct {p0, p1}, Lgf/i;-><init>(Lgf/i$b;)V

    const/4 v0, -0x1

    .line 4
    iput-byte v0, p0, Lze/q$b;->g:B

    .line 5
    iput v0, p0, Lze/q$b;->h:I

    .line 6
    invoke-virtual {p1}, Lgf/i$b;->i()Lgf/d;

    move-result-object p1

    iput-object p1, p0, Lze/q$b;->b:Lgf/d;

    return-void
.end method

.method public synthetic constructor <init>(Lgf/i$b;Lze/a;)V
    .locals 0

    .line 2
    invoke-direct {p0, p1}, Lze/q$b;-><init>(Lgf/i$b;)V

    return-void
.end method

.method public constructor <init>(Z)V
    .locals 0

    .line 7
    invoke-direct {p0}, Lgf/i;-><init>()V

    const/4 p1, -0x1

    .line 8
    iput-byte p1, p0, Lze/q$b;->g:B

    .line 9
    iput p1, p0, Lze/q$b;->h:I

    .line 10
    sget-object p1, Lgf/d;->a:Lgf/d;

    iput-object p1, p0, Lze/q$b;->b:Lgf/d;

    return-void
.end method

.method private D()V
    .locals 1

    .line 1
    sget-object v0, Lze/q$b$c;->d:Lze/q$b$c;

    .line 2
    .line 3
    iput-object v0, p0, Lze/q$b;->d:Lze/q$b$c;

    .line 4
    .line 5
    invoke-static {}, Lze/q;->X()Lze/q;

    .line 6
    .line 7
    .line 8
    move-result-object v0

    .line 9
    iput-object v0, p0, Lze/q$b;->e:Lze/q;

    .line 10
    .line 11
    const/4 v0, 0x0

    .line 12
    iput v0, p0, Lze/q$b;->f:I

    .line 13
    .line 14
    return-void
    .line 15
    .line 16
    .line 17
    .line 18
    .line 19
.end method

.method public static E()Lze/q$b$b;
    .locals 1

    .line 1
    invoke-static {}, Lze/q$b$b;->l()Lze/q$b$b;

    .line 2
    .line 3
    .line 4
    move-result-object v0

    .line 5
    return-object v0
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
    .line 17
    .line 18
    .line 19
.end method

.method public static F(Lze/q$b;)Lze/q$b$b;
    .locals 1

    .line 1
    invoke-static {}, Lze/q$b;->E()Lze/q$b$b;

    .line 2
    .line 3
    .line 4
    move-result-object v0

    .line 5
    invoke-virtual {v0, p0}, Lze/q$b$b;->s(Lze/q$b;)Lze/q$b$b;

    .line 6
    .line 7
    .line 8
    move-result-object p0

    .line 9
    return-object p0
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
.end method

.method public static synthetic q(Lze/q$b;Lze/q$b$c;)Lze/q$b$c;
    .locals 0

    .line 1
    iput-object p1, p0, Lze/q$b;->d:Lze/q$b$c;

    .line 2
    .line 3
    return-object p1
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
    .line 40
    .line 41
    .line 42
    .line 43
    .line 44
    .line 45
    .line 46
    .line 47
    .line 48
.end method

.method public static synthetic r(Lze/q$b;Lze/q;)Lze/q;
    .locals 0

    .line 1
    iput-object p1, p0, Lze/q$b;->e:Lze/q;

    .line 2
    .line 3
    return-object p1
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
    .line 40
    .line 41
    .line 42
    .line 43
    .line 44
    .line 45
    .line 46
    .line 47
    .line 48
.end method

.method public static synthetic s(Lze/q$b;I)I
    .locals 0

    .line 1
    iput p1, p0, Lze/q$b;->f:I

    .line 2
    .line 3
    return p1
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
    .line 40
    .line 41
    .line 42
    .line 43
    .line 44
    .line 45
    .line 46
    .line 47
    .line 48
.end method

.method public static synthetic t(Lze/q$b;I)I
    .locals 0

    .line 1
    iput p1, p0, Lze/q$b;->c:I

    .line 2
    .line 3
    return p1
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
    .line 40
    .line 41
    .line 42
    .line 43
    .line 44
    .line 45
    .line 46
    .line 47
    .line 48
.end method

.method public static synthetic v(Lze/q$b;)Lgf/d;
    .locals 0

    .line 1
    iget-object p0, p0, Lze/q$b;->b:Lgf/d;

    .line 2
    .line 3
    return-object p0
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
.end method

.method public static w()Lze/q$b;
    .locals 1

    .line 1
    sget-object v0, Lze/q$b;->i:Lze/q$b;

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
    .line 17
    .line 18
    .line 19
.end method


# virtual methods
.method public A()Z
    .locals 2

    .line 1
    iget v0, p0, Lze/q$b;->c:I

    .line 2
    .line 3
    const/4 v1, 0x1

    .line 4
    and-int/2addr v0, v1

    .line 5
    if-ne v0, v1, :cond_0

    .line 6
    .line 7
    return v1

    .line 8
    :cond_0
    const/4 v0, 0x0

    .line 9
    return v0
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
.end method

.method public B()Z
    .locals 2

    .line 1
    iget v0, p0, Lze/q$b;->c:I

    .line 2
    .line 3
    const/4 v1, 0x2

    .line 4
    and-int/2addr v0, v1

    .line 5
    if-ne v0, v1, :cond_0

    .line 6
    .line 7
    const/4 v0, 0x1

    .line 8
    return v0

    .line 9
    :cond_0
    const/4 v0, 0x0

    .line 10
    return v0
    .line 11
    .line 12
    .line 13
    .line 14
    .line 15
    .line 16
    .line 17
    .line 18
    .line 19
.end method

.method public C()Z
    .locals 2

    .line 1
    iget v0, p0, Lze/q$b;->c:I

    .line 2
    .line 3
    const/4 v1, 0x4

    .line 4
    and-int/2addr v0, v1

    .line 5
    if-ne v0, v1, :cond_0

    .line 6
    .line 7
    const/4 v0, 0x1

    .line 8
    return v0

    .line 9
    :cond_0
    const/4 v0, 0x0

    .line 10
    return v0
    .line 11
    .line 12
    .line 13
    .line 14
    .line 15
    .line 16
    .line 17
    .line 18
    .line 19
.end method

.method public G()Lze/q$b$b;
    .locals 1

    .line 1
    invoke-static {}, Lze/q$b;->E()Lze/q$b$b;

    .line 2
    .line 3
    .line 4
    move-result-object v0

    .line 5
    return-object v0
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
    .line 17
    .line 18
    .line 19
.end method

.method public H()Lze/q$b$b;
    .locals 1

    .line 1
    invoke-static {p0}, Lze/q$b;->F(Lze/q$b;)Lze/q$b$b;

    .line 2
    .line 3
    .line 4
    move-result-object v0

    .line 5
    return-object v0
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
    .line 17
    .line 18
    .line 19
.end method

.method public b()I
    .locals 3

    .line 1
    iget v0, p0, Lze/q$b;->h:I

    .line 2
    .line 3
    const/4 v1, -0x1

    .line 4
    if-eq v0, v1, :cond_0

    .line 5
    .line 6
    return v0

    .line 7
    :cond_0
    iget v0, p0, Lze/q$b;->c:I

    .line 8
    .line 9
    const/4 v1, 0x1

    .line 10
    and-int/2addr v0, v1

    .line 11
    if-ne v0, v1, :cond_1

    .line 12
    .line 13
    iget-object v0, p0, Lze/q$b;->d:Lze/q$b$c;

    .line 14
    .line 15
    invoke-virtual {v0}, Lze/q$b$c;->d()I

    .line 16
    .line 17
    .line 18
    move-result v0

    .line 19
    invoke-static {v1, v0}, Lgf/f;->h(II)I

    .line 20
    .line 21
    .line 22
    move-result v0

    .line 23
    goto :goto_0

    .line 24
    :cond_1
    const/4 v0, 0x0

    .line 25
    :goto_0
    iget v1, p0, Lze/q$b;->c:I

    .line 26
    .line 27
    const/4 v2, 0x2

    .line 28
    and-int/2addr v1, v2

    .line 29
    if-ne v1, v2, :cond_2

    .line 30
    .line 31
    iget-object v1, p0, Lze/q$b;->e:Lze/q;

    .line 32
    .line 33
    invoke-static {v2, v1}, Lgf/f;->r(ILgf/p;)I

    .line 34
    .line 35
    .line 36
    move-result v1

    .line 37
    add-int/2addr v0, v1

    .line 38
    :cond_2
    iget v1, p0, Lze/q$b;->c:I

    .line 39
    .line 40
    const/4 v2, 0x4

    .line 41
    and-int/2addr v1, v2

    .line 42
    if-ne v1, v2, :cond_3

    .line 43
    .line 44
    const/4 v1, 0x3

    .line 45
    iget v2, p0, Lze/q$b;->f:I

    .line 46
    .line 47
    invoke-static {v1, v2}, Lgf/f;->o(II)I

    .line 48
    .line 49
    .line 50
    move-result v1

    .line 51
    add-int/2addr v0, v1

    .line 52
    :cond_3
    iget-object v1, p0, Lze/q$b;->b:Lgf/d;

    .line 53
    .line 54
    invoke-virtual {v1}, Lgf/d;->size()I

    .line 55
    .line 56
    .line 57
    move-result v1

    .line 58
    add-int/2addr v0, v1

    .line 59
    iput v0, p0, Lze/q$b;->h:I

    .line 60
    .line 61
    return v0
    .line 62
    .line 63
    .line 64
    .line 65
    .line 66
    .line 67
    .line 68
    .line 69
    .line 70
    .line 71
    .line 72
    .line 73
    .line 74
    .line 75
    .line 76
    .line 77
    .line 78
    .line 79
    .line 80
    .line 81
    .line 82
.end method

.method public bridge synthetic c()Lgf/p$a;
    .locals 1

    .line 1
    invoke-virtual {p0}, Lze/q$b;->G()Lze/q$b$b;

    .line 2
    .line 3
    .line 4
    move-result-object v0

    .line 5
    return-object v0
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
    .line 17
    .line 18
    .line 19
.end method

.method public final d()Z
    .locals 3

    .line 1
    iget-byte v0, p0, Lze/q$b;->g:B

    .line 2
    .line 3
    const/4 v1, 0x1

    .line 4
    if-ne v0, v1, :cond_0

    .line 5
    .line 6
    return v1

    .line 7
    :cond_0
    const/4 v2, 0x0

    .line 8
    if-nez v0, :cond_1

    .line 9
    .line 10
    return v2

    .line 11
    :cond_1
    invoke-virtual {p0}, Lze/q$b;->B()Z

    .line 12
    .line 13
    .line 14
    move-result v0

    .line 15
    if-eqz v0, :cond_2

    .line 16
    .line 17
    invoke-virtual {p0}, Lze/q$b;->y()Lze/q;

    .line 18
    .line 19
    .line 20
    move-result-object v0

    .line 21
    invoke-virtual {v0}, Lze/q;->d()Z

    .line 22
    .line 23
    .line 24
    move-result v0

    .line 25
    if-nez v0, :cond_2

    .line 26
    .line 27
    iput-byte v2, p0, Lze/q$b;->g:B

    .line 28
    .line 29
    return v2

    .line 30
    :cond_2
    iput-byte v1, p0, Lze/q$b;->g:B

    .line 31
    .line 32
    return v1
    .line 33
    .line 34
    .line 35
    .line 36
    .line 37
    .line 38
    .line 39
    .line 40
    .line 41
    .line 42
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
    .line 62
    .line 63
    .line 64
    .line 65
    .line 66
    .line 67
    .line 68
    .line 69
    .line 70
    .line 71
    .line 72
    .line 73
    .line 74
    .line 75
    .line 76
    .line 77
    .line 78
    .line 79
    .line 80
    .line 81
    .line 82
.end method

.method public bridge synthetic f()Lgf/p$a;
    .locals 1

    .line 1
    invoke-virtual {p0}, Lze/q$b;->H()Lze/q$b$b;

    .line 2
    .line 3
    .line 4
    move-result-object v0

    .line 5
    return-object v0
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
    .line 17
    .line 18
    .line 19
.end method

.method public g(Lgf/f;)V
    .locals 2

    .line 1
    invoke-virtual {p0}, Lze/q$b;->b()I

    .line 2
    .line 3
    .line 4
    iget v0, p0, Lze/q$b;->c:I

    .line 5
    .line 6
    const/4 v1, 0x1

    .line 7
    and-int/2addr v0, v1

    .line 8
    if-ne v0, v1, :cond_0

    .line 9
    .line 10
    iget-object v0, p0, Lze/q$b;->d:Lze/q$b$c;

    .line 11
    .line 12
    invoke-virtual {v0}, Lze/q$b$c;->d()I

    .line 13
    .line 14
    .line 15
    move-result v0

    .line 16
    invoke-virtual {p1, v1, v0}, Lgf/f;->R(II)V

    .line 17
    .line 18
    .line 19
    :cond_0
    iget v0, p0, Lze/q$b;->c:I

    .line 20
    .line 21
    const/4 v1, 0x2

    .line 22
    and-int/2addr v0, v1

    .line 23
    if-ne v0, v1, :cond_1

    .line 24
    .line 25
    iget-object v0, p0, Lze/q$b;->e:Lze/q;

    .line 26
    .line 27
    invoke-virtual {p1, v1, v0}, Lgf/f;->c0(ILgf/p;)V

    .line 28
    .line 29
    .line 30
    :cond_1
    iget v0, p0, Lze/q$b;->c:I

    .line 31
    .line 32
    const/4 v1, 0x4

    .line 33
    and-int/2addr v0, v1

    .line 34
    if-ne v0, v1, :cond_2

    .line 35
    .line 36
    const/4 v0, 0x3

    .line 37
    iget v1, p0, Lze/q$b;->f:I

    .line 38
    .line 39
    invoke-virtual {p1, v0, v1}, Lgf/f;->Z(II)V

    .line 40
    .line 41
    .line 42
    :cond_2
    iget-object v0, p0, Lze/q$b;->b:Lgf/d;

    .line 43
    .line 44
    invoke-virtual {p1, v0}, Lgf/f;->h0(Lgf/d;)V

    .line 45
    .line 46
    .line 47
    return-void
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
    .line 62
    .line 63
    .line 64
    .line 65
    .line 66
    .line 67
    .line 68
    .line 69
    .line 70
    .line 71
    .line 72
    .line 73
    .line 74
    .line 75
    .line 76
    .line 77
    .line 78
    .line 79
    .line 80
    .line 81
    .line 82
    .line 83
    .line 84
    .line 85
    .line 86
    .line 87
    .line 88
    .line 89
    .line 90
    .line 91
    .line 92
    .line 93
    .line 94
    .line 95
    .line 96
    .line 97
    .line 98
    .line 99
.end method

.method public x()Lze/q$b$c;
    .locals 1

    .line 1
    iget-object v0, p0, Lze/q$b;->d:Lze/q$b$c;

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
    .line 17
    .line 18
    .line 19
.end method

.method public y()Lze/q;
    .locals 1

    .line 1
    iget-object v0, p0, Lze/q$b;->e:Lze/q;

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
    .line 17
    .line 18
    .line 19
.end method

.method public z()I
    .locals 1

    .line 1
    iget v0, p0, Lze/q$b;->f:I

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
    .line 17
    .line 18
    .line 19
.end method
