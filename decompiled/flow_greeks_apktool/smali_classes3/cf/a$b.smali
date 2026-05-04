.class public final Lcf/a$b;
.super Lgf/i;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"

# interfaces
.implements Lgf/q;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcf/a;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "b"
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcf/a$b$b;
    }
.end annotation


# static fields
.field public static final h:Lcf/a$b;

.field public static i:Lgf/r;


# instance fields
.field public final b:Lgf/d;

.field public c:I

.field public d:I

.field public e:I

.field public f:B

.field public g:I


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .line 1
    new-instance v0, Lcf/a$b$a;

    .line 2
    .line 3
    invoke-direct {v0}, Lcf/a$b$a;-><init>()V

    .line 4
    .line 5
    .line 6
    sput-object v0, Lcf/a$b;->i:Lgf/r;

    .line 7
    .line 8
    new-instance v0, Lcf/a$b;

    .line 9
    .line 10
    const/4 v1, 0x1

    .line 11
    invoke-direct {v0, v1}, Lcf/a$b;-><init>(Z)V

    .line 12
    .line 13
    .line 14
    sput-object v0, Lcf/a$b;->h:Lcf/a$b;

    .line 15
    .line 16
    invoke-direct {v0}, Lcf/a$b;->A()V

    .line 17
    .line 18
    .line 19
    return-void
.end method

.method public constructor <init>(Lgf/e;Lgf/g;)V
    .locals 6

    .line 11
    invoke-direct {p0}, Lgf/i;-><init>()V

    const/4 v0, -0x1

    .line 12
    iput-byte v0, p0, Lcf/a$b;->f:B

    .line 13
    iput v0, p0, Lcf/a$b;->g:I

    .line 14
    invoke-direct {p0}, Lcf/a$b;->A()V

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
    if-nez v3, :cond_4

    .line 17
    :try_start_0
    invoke-virtual {p1}, Lgf/e;->J()I

    move-result v4

    if-eqz v4, :cond_1

    const/16 v5, 0x8

    if-eq v4, v5, :cond_3

    const/16 v5, 0x10

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

    goto :goto_3

    :catch_0
    move-exception p1

    goto :goto_1

    :catch_1
    move-exception p1

    goto :goto_2

    .line 19
    :cond_2
    iget v4, p0, Lcf/a$b;->c:I

    or-int/lit8 v4, v4, 0x2

    iput v4, p0, Lcf/a$b;->c:I

    .line 20
    invoke-virtual {p1}, Lgf/e;->r()I

    move-result v4

    iput v4, p0, Lcf/a$b;->e:I

    goto :goto_0

    .line 21
    :cond_3
    iget v4, p0, Lcf/a$b;->c:I

    or-int/2addr v4, v1

    iput v4, p0, Lcf/a$b;->c:I

    .line 22
    invoke-virtual {p1}, Lgf/e;->r()I

    move-result v4

    iput v4, p0, Lcf/a$b;->d:I
    :try_end_0
    .catch Lgf/k; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_0

    .line 23
    :goto_1
    :try_start_1
    new-instance p2, Lgf/k;

    .line 24
    invoke-virtual {p1}, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;

    move-result-object p1

    invoke-direct {p2, p1}, Lgf/k;-><init>(Ljava/lang/String;)V

    invoke-virtual {p2, p0}, Lgf/k;->i(Lgf/p;)Lgf/k;

    move-result-object p1

    throw p1

    .line 25
    :goto_2
    invoke-virtual {p1, p0}, Lgf/k;->i(Lgf/p;)Lgf/k;

    move-result-object p1

    throw p1
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 26
    :goto_3
    :try_start_2
    invoke-virtual {v2}, Lgf/f;->H()V
    :try_end_2
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    .line 27
    :catch_2
    invoke-virtual {v0}, Lgf/d$b;->u()Lgf/d;

    move-result-object p2

    iput-object p2, p0, Lcf/a$b;->b:Lgf/d;

    goto :goto_4

    :catchall_1
    move-exception p1

    invoke-virtual {v0}, Lgf/d$b;->u()Lgf/d;

    move-result-object p2

    iput-object p2, p0, Lcf/a$b;->b:Lgf/d;

    .line 28
    throw p1

    .line 29
    :goto_4
    invoke-virtual {p0}, Lgf/i;->l()V

    .line 30
    throw p1

    .line 31
    :cond_4
    :try_start_3
    invoke-virtual {v2}, Lgf/f;->H()V
    :try_end_3
    .catch Ljava/io/IOException; {:try_start_3 .. :try_end_3} :catch_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_2

    .line 32
    :catch_3
    invoke-virtual {v0}, Lgf/d$b;->u()Lgf/d;

    move-result-object p1

    iput-object p1, p0, Lcf/a$b;->b:Lgf/d;

    goto :goto_5

    :catchall_2
    move-exception p1

    invoke-virtual {v0}, Lgf/d$b;->u()Lgf/d;

    move-result-object p2

    iput-object p2, p0, Lcf/a$b;->b:Lgf/d;

    .line 33
    throw p1

    .line 34
    :goto_5
    invoke-virtual {p0}, Lgf/i;->l()V

    return-void
.end method

.method public synthetic constructor <init>(Lgf/e;Lgf/g;Lcf/a$a;)V
    .locals 0

    .line 1
    invoke-direct {p0, p1, p2}, Lcf/a$b;-><init>(Lgf/e;Lgf/g;)V

    return-void
.end method

.method public constructor <init>(Lgf/i$b;)V
    .locals 1

    .line 3
    invoke-direct {p0, p1}, Lgf/i;-><init>(Lgf/i$b;)V

    const/4 v0, -0x1

    .line 4
    iput-byte v0, p0, Lcf/a$b;->f:B

    .line 5
    iput v0, p0, Lcf/a$b;->g:I

    .line 6
    invoke-virtual {p1}, Lgf/i$b;->i()Lgf/d;

    move-result-object p1

    iput-object p1, p0, Lcf/a$b;->b:Lgf/d;

    return-void
.end method

.method public synthetic constructor <init>(Lgf/i$b;Lcf/a$a;)V
    .locals 0

    .line 2
    invoke-direct {p0, p1}, Lcf/a$b;-><init>(Lgf/i$b;)V

    return-void
.end method

.method public constructor <init>(Z)V
    .locals 0

    .line 7
    invoke-direct {p0}, Lgf/i;-><init>()V

    const/4 p1, -0x1

    .line 8
    iput-byte p1, p0, Lcf/a$b;->f:B

    .line 9
    iput p1, p0, Lcf/a$b;->g:I

    .line 10
    sget-object p1, Lgf/d;->a:Lgf/d;

    iput-object p1, p0, Lcf/a$b;->b:Lgf/d;

    return-void
.end method

.method private A()V
    .locals 1

    .line 1
    const/4 v0, 0x0

    .line 2
    iput v0, p0, Lcf/a$b;->d:I

    .line 3
    .line 4
    iput v0, p0, Lcf/a$b;->e:I

    .line 5
    .line 6
    return-void
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

.method public static B()Lcf/a$b$b;
    .locals 1

    .line 1
    invoke-static {}, Lcf/a$b$b;->l()Lcf/a$b$b;

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

.method public static C(Lcf/a$b;)Lcf/a$b$b;
    .locals 1

    .line 1
    invoke-static {}, Lcf/a$b;->B()Lcf/a$b$b;

    .line 2
    .line 3
    .line 4
    move-result-object v0

    .line 5
    invoke-virtual {v0, p0}, Lcf/a$b$b;->r(Lcf/a$b;)Lcf/a$b$b;

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

.method public static synthetic q(Lcf/a$b;I)I
    .locals 0

    .line 1
    iput p1, p0, Lcf/a$b;->d:I

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

.method public static synthetic r(Lcf/a$b;I)I
    .locals 0

    .line 1
    iput p1, p0, Lcf/a$b;->e:I

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

.method public static synthetic s(Lcf/a$b;I)I
    .locals 0

    .line 1
    iput p1, p0, Lcf/a$b;->c:I

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

.method public static synthetic t(Lcf/a$b;)Lgf/d;
    .locals 0

    .line 1
    iget-object p0, p0, Lcf/a$b;->b:Lgf/d;

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

.method public static v()Lcf/a$b;
    .locals 1

    .line 1
    sget-object v0, Lcf/a$b;->h:Lcf/a$b;

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
.method public D()Lcf/a$b$b;
    .locals 1

    .line 1
    invoke-static {}, Lcf/a$b;->B()Lcf/a$b$b;

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

.method public E()Lcf/a$b$b;
    .locals 1

    .line 1
    invoke-static {p0}, Lcf/a$b;->C(Lcf/a$b;)Lcf/a$b$b;

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
    iget v0, p0, Lcf/a$b;->g:I

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
    iget v0, p0, Lcf/a$b;->c:I

    .line 8
    .line 9
    const/4 v1, 0x1

    .line 10
    and-int/2addr v0, v1

    .line 11
    if-ne v0, v1, :cond_1

    .line 12
    .line 13
    iget v0, p0, Lcf/a$b;->d:I

    .line 14
    .line 15
    invoke-static {v1, v0}, Lgf/f;->o(II)I

    .line 16
    .line 17
    .line 18
    move-result v0

    .line 19
    goto :goto_0

    .line 20
    :cond_1
    const/4 v0, 0x0

    .line 21
    :goto_0
    iget v1, p0, Lcf/a$b;->c:I

    .line 22
    .line 23
    const/4 v2, 0x2

    .line 24
    and-int/2addr v1, v2

    .line 25
    if-ne v1, v2, :cond_2

    .line 26
    .line 27
    iget v1, p0, Lcf/a$b;->e:I

    .line 28
    .line 29
    invoke-static {v2, v1}, Lgf/f;->o(II)I

    .line 30
    .line 31
    .line 32
    move-result v1

    .line 33
    add-int/2addr v0, v1

    .line 34
    :cond_2
    iget-object v1, p0, Lcf/a$b;->b:Lgf/d;

    .line 35
    .line 36
    invoke-virtual {v1}, Lgf/d;->size()I

    .line 37
    .line 38
    .line 39
    move-result v1

    .line 40
    add-int/2addr v0, v1

    .line 41
    iput v0, p0, Lcf/a$b;->g:I

    .line 42
    .line 43
    return v0
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

.method public bridge synthetic c()Lgf/p$a;
    .locals 1

    .line 1
    invoke-virtual {p0}, Lcf/a$b;->D()Lcf/a$b$b;

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
    .locals 2

    .line 1
    iget-byte v0, p0, Lcf/a$b;->f:B

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
    if-nez v0, :cond_1

    .line 8
    .line 9
    const/4 v0, 0x0

    .line 10
    return v0

    .line 11
    :cond_1
    iput-byte v1, p0, Lcf/a$b;->f:B

    .line 12
    .line 13
    return v1
    .line 14
    .line 15
    .line 16
    .line 17
    .line 18
    .line 19
.end method

.method public bridge synthetic f()Lgf/p$a;
    .locals 1

    .line 1
    invoke-virtual {p0}, Lcf/a$b;->E()Lcf/a$b$b;

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
    invoke-virtual {p0}, Lcf/a$b;->b()I

    .line 2
    .line 3
    .line 4
    iget v0, p0, Lcf/a$b;->c:I

    .line 5
    .line 6
    const/4 v1, 0x1

    .line 7
    and-int/2addr v0, v1

    .line 8
    if-ne v0, v1, :cond_0

    .line 9
    .line 10
    iget v0, p0, Lcf/a$b;->d:I

    .line 11
    .line 12
    invoke-virtual {p1, v1, v0}, Lgf/f;->Z(II)V

    .line 13
    .line 14
    .line 15
    :cond_0
    iget v0, p0, Lcf/a$b;->c:I

    .line 16
    .line 17
    const/4 v1, 0x2

    .line 18
    and-int/2addr v0, v1

    .line 19
    if-ne v0, v1, :cond_1

    .line 20
    .line 21
    iget v0, p0, Lcf/a$b;->e:I

    .line 22
    .line 23
    invoke-virtual {p1, v1, v0}, Lgf/f;->Z(II)V

    .line 24
    .line 25
    .line 26
    :cond_1
    iget-object v0, p0, Lcf/a$b;->b:Lgf/d;

    .line 27
    .line 28
    invoke-virtual {p1, v0}, Lgf/f;->h0(Lgf/d;)V

    .line 29
    .line 30
    .line 31
    return-void
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

.method public w()I
    .locals 1

    .line 1
    iget v0, p0, Lcf/a$b;->e:I

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

.method public x()I
    .locals 1

    .line 1
    iget v0, p0, Lcf/a$b;->d:I

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

.method public y()Z
    .locals 2

    .line 1
    iget v0, p0, Lcf/a$b;->c:I

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

.method public z()Z
    .locals 2

    .line 1
    iget v0, p0, Lcf/a$b;->c:I

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
