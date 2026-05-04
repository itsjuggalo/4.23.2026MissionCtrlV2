.class public final Lc5/c$a;
.super Ljava/lang/Object;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lc5/c;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "a"
.end annotation


# instance fields
.field public a:Lc5/c$e;

.field public b:Lc5/c$b;

.field public c:Lc5/c$d;

.field public d:Lc5/c$c;

.field public e:Ljava/lang/String;

.field public f:Z

.field public g:I

.field public h:Z


# direct methods
.method public constructor <init>()V
    .locals 2

    .line 1
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 2
    .line 3
    .line 4
    invoke-static {}, Lc5/c$e;->R()Lc5/c$e$a;

    .line 5
    .line 6
    .line 7
    move-result-object v0

    .line 8
    const/4 v1, 0x0

    .line 9
    invoke-virtual {v0, v1}, Lc5/c$e$a;->b(Z)Lc5/c$e$a;

    .line 10
    .line 11
    .line 12
    invoke-virtual {v0}, Lc5/c$e$a;->a()Lc5/c$e;

    .line 13
    .line 14
    .line 15
    move-result-object v0

    .line 16
    iput-object v0, p0, Lc5/c$a;->a:Lc5/c$e;

    .line 17
    .line 18
    invoke-static {}, Lc5/c$b;->R()Lc5/c$b$a;

    .line 19
    .line 20
    .line 21
    move-result-object v0

    .line 22
    invoke-virtual {v0, v1}, Lc5/c$b$a;->g(Z)Lc5/c$b$a;

    .line 23
    .line 24
    .line 25
    invoke-virtual {v0}, Lc5/c$b$a;->b()Lc5/c$b;

    .line 26
    .line 27
    .line 28
    move-result-object v0

    .line 29
    iput-object v0, p0, Lc5/c$a;->b:Lc5/c$b;

    .line 30
    .line 31
    invoke-static {}, Lc5/c$d;->R()Lc5/c$d$a;

    .line 32
    .line 33
    .line 34
    move-result-object v0

    .line 35
    invoke-virtual {v0, v1}, Lc5/c$d$a;->b(Z)Lc5/c$d$a;

    .line 36
    .line 37
    .line 38
    invoke-virtual {v0}, Lc5/c$d$a;->a()Lc5/c$d;

    .line 39
    .line 40
    .line 41
    move-result-object v0

    .line 42
    iput-object v0, p0, Lc5/c$a;->c:Lc5/c$d;

    .line 43
    .line 44
    invoke-static {}, Lc5/c$c;->R()Lc5/c$c$a;

    .line 45
    .line 46
    .line 47
    move-result-object v0

    .line 48
    invoke-virtual {v0, v1}, Lc5/c$c$a;->b(Z)Lc5/c$c$a;

    .line 49
    .line 50
    .line 51
    invoke-virtual {v0}, Lc5/c$c$a;->a()Lc5/c$c;

    .line 52
    .line 53
    .line 54
    move-result-object v0

    .line 55
    iput-object v0, p0, Lc5/c$a;->d:Lc5/c$c;

    .line 56
    .line 57
    return-void
    .line 58
    .line 59
    .line 60
    .line 61
.end method


# virtual methods
.method public a()Lc5/c;
    .locals 9

    .line 1
    new-instance v0, Lc5/c;

    .line 2
    .line 3
    iget-object v1, p0, Lc5/c$a;->a:Lc5/c$e;

    .line 4
    .line 5
    iget-object v2, p0, Lc5/c$a;->b:Lc5/c$b;

    .line 6
    .line 7
    iget-object v3, p0, Lc5/c$a;->e:Ljava/lang/String;

    .line 8
    .line 9
    iget-boolean v4, p0, Lc5/c$a;->f:Z

    .line 10
    .line 11
    iget v5, p0, Lc5/c$a;->g:I

    .line 12
    .line 13
    iget-object v6, p0, Lc5/c$a;->c:Lc5/c$d;

    .line 14
    .line 15
    iget-object v7, p0, Lc5/c$a;->d:Lc5/c$c;

    .line 16
    .line 17
    iget-boolean v8, p0, Lc5/c$a;->h:Z

    .line 18
    .line 19
    invoke-direct/range {v0 .. v8}, Lc5/c;-><init>(Lc5/c$e;Lc5/c$b;Ljava/lang/String;ZILc5/c$d;Lc5/c$c;Z)V

    .line 20
    .line 21
    .line 22
    return-object v0
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

.method public b(Z)Lc5/c$a;
    .locals 0

    .line 1
    iput-boolean p1, p0, Lc5/c$a;->f:Z

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
.end method

.method public c(Lc5/c$b;)Lc5/c$a;
    .locals 0

    .line 1
    invoke-static {p1}, Lcom/google/android/gms/common/internal/s;->k(Ljava/lang/Object;)Ljava/lang/Object;

    .line 2
    .line 3
    .line 4
    move-result-object p1

    .line 5
    check-cast p1, Lc5/c$b;

    .line 6
    .line 7
    iput-object p1, p0, Lc5/c$a;->b:Lc5/c$b;

    .line 8
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
.end method

.method public d(Lc5/c$c;)Lc5/c$a;
    .locals 0

    .line 1
    invoke-static {p1}, Lcom/google/android/gms/common/internal/s;->k(Ljava/lang/Object;)Ljava/lang/Object;

    .line 2
    .line 3
    .line 4
    move-result-object p1

    .line 5
    check-cast p1, Lc5/c$c;

    .line 6
    .line 7
    iput-object p1, p0, Lc5/c$a;->d:Lc5/c$c;

    .line 8
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
.end method

.method public e(Lc5/c$d;)Lc5/c$a;
    .locals 0

    .line 1
    invoke-static {p1}, Lcom/google/android/gms/common/internal/s;->k(Ljava/lang/Object;)Ljava/lang/Object;

    .line 2
    .line 3
    .line 4
    move-result-object p1

    .line 5
    check-cast p1, Lc5/c$d;

    .line 6
    .line 7
    iput-object p1, p0, Lc5/c$a;->c:Lc5/c$d;

    .line 8
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
.end method

.method public f(Lc5/c$e;)Lc5/c$a;
    .locals 0

    .line 1
    invoke-static {p1}, Lcom/google/android/gms/common/internal/s;->k(Ljava/lang/Object;)Ljava/lang/Object;

    .line 2
    .line 3
    .line 4
    move-result-object p1

    .line 5
    check-cast p1, Lc5/c$e;

    .line 6
    .line 7
    iput-object p1, p0, Lc5/c$a;->a:Lc5/c$e;

    .line 8
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
.end method

.method public g(Z)Lc5/c$a;
    .locals 0

    .line 1
    iput-boolean p1, p0, Lc5/c$a;->h:Z

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
.end method

.method public final h(Ljava/lang/String;)Lc5/c$a;
    .locals 0

    .line 1
    iput-object p1, p0, Lc5/c$a;->e:Ljava/lang/String;

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
.end method

.method public final i(I)Lc5/c$a;
    .locals 0

    .line 1
    iput p1, p0, Lc5/c$a;->g:I

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
.end method
