.class public final Leh/d$a;
.super Ljava/lang/Object;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"

# interfaces
.implements Lbh/e;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Leh/d;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "a"
.end annotation


# static fields
.field public static final b:Leh/d$a;

.field public static final c:Ljava/lang/String;


# instance fields
.field public final synthetic a:Lbh/e;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .line 1
    new-instance v0, Leh/d$a;

    .line 2
    .line 3
    invoke-direct {v0}, Leh/d$a;-><init>()V

    .line 4
    .line 5
    .line 6
    sput-object v0, Leh/d$a;->b:Leh/d$a;

    .line 7
    .line 8
    const-string v0, "kotlinx.serialization.json.JsonArray"

    .line 9
    .line 10
    sput-object v0, Leh/d$a;->c:Ljava/lang/String;

    .line 11
    .line 12
    return-void
    .line 13
    .line 14
    .line 15
    .line 16
    .line 17
    .line 18
    .line 19
.end method

.method public constructor <init>()V
    .locals 1

    .line 1
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 2
    .line 3
    .line 4
    sget-object v0, Leh/q;->a:Leh/q;

    .line 5
    .line 6
    invoke-static {v0}, Lah/a;->g(Lzg/b;)Lzg/b;

    .line 7
    .line 8
    .line 9
    move-result-object v0

    .line 10
    invoke-interface {v0}, Lzg/b;->getDescriptor()Lbh/e;

    .line 11
    .line 12
    .line 13
    move-result-object v0

    .line 14
    iput-object v0, p0, Leh/d$a;->a:Lbh/e;

    .line 15
    .line 16
    return-void
    .line 17
    .line 18
    .line 19
.end method


# virtual methods
.method public getAnnotations()Ljava/util/List;
    .locals 1

    .line 1
    iget-object v0, p0, Leh/d$a;->a:Lbh/e;

    .line 2
    .line 3
    invoke-interface {v0}, Lbh/e;->getAnnotations()Ljava/util/List;

    .line 4
    .line 5
    .line 6
    move-result-object v0

    .line 7
    return-object v0
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

.method public h()Lbh/l;
    .locals 1

    .line 1
    iget-object v0, p0, Leh/d$a;->a:Lbh/e;

    .line 2
    .line 3
    invoke-interface {v0}, Lbh/e;->h()Lbh/l;

    .line 4
    .line 5
    .line 6
    move-result-object v0

    .line 7
    return-object v0
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

.method public i()Ljava/lang/String;
    .locals 1

    .line 1
    sget-object v0, Leh/d$a;->c:Ljava/lang/String;

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

.method public isInline()Z
    .locals 1

    .line 1
    iget-object v0, p0, Leh/d$a;->a:Lbh/e;

    .line 2
    .line 3
    invoke-interface {v0}, Lbh/e;->isInline()Z

    .line 4
    .line 5
    .line 6
    move-result v0

    .line 7
    return v0
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

.method public j()Z
    .locals 1

    .line 1
    iget-object v0, p0, Leh/d$a;->a:Lbh/e;

    .line 2
    .line 3
    invoke-interface {v0}, Lbh/e;->j()Z

    .line 4
    .line 5
    .line 6
    move-result v0

    .line 7
    return v0
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

.method public k(Ljava/lang/String;)I
    .locals 1

    .line 1
    const-string v0, "name"

    .line 2
    .line 3
    invoke-static {p1, v0}, Lkotlin/jvm/internal/t;->f(Ljava/lang/Object;Ljava/lang/String;)V

    .line 4
    .line 5
    .line 6
    iget-object v0, p0, Leh/d$a;->a:Lbh/e;

    .line 7
    .line 8
    invoke-interface {v0, p1}, Lbh/e;->k(Ljava/lang/String;)I

    .line 9
    .line 10
    .line 11
    move-result p1

    .line 12
    return p1
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

.method public l()I
    .locals 1

    .line 1
    iget-object v0, p0, Leh/d$a;->a:Lbh/e;

    .line 2
    .line 3
    invoke-interface {v0}, Lbh/e;->l()I

    .line 4
    .line 5
    .line 6
    move-result v0

    .line 7
    return v0
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

.method public m(I)Ljava/lang/String;
    .locals 1

    .line 1
    iget-object v0, p0, Leh/d$a;->a:Lbh/e;

    .line 2
    .line 3
    invoke-interface {v0, p1}, Lbh/e;->m(I)Ljava/lang/String;

    .line 4
    .line 5
    .line 6
    move-result-object p1

    .line 7
    return-object p1
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

.method public n(I)Ljava/util/List;
    .locals 1

    .line 1
    iget-object v0, p0, Leh/d$a;->a:Lbh/e;

    .line 2
    .line 3
    invoke-interface {v0, p1}, Lbh/e;->n(I)Ljava/util/List;

    .line 4
    .line 5
    .line 6
    move-result-object p1

    .line 7
    return-object p1
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

.method public o(I)Lbh/e;
    .locals 1

    .line 1
    iget-object v0, p0, Leh/d$a;->a:Lbh/e;

    .line 2
    .line 3
    invoke-interface {v0, p1}, Lbh/e;->o(I)Lbh/e;

    .line 4
    .line 5
    .line 6
    move-result-object p1

    .line 7
    return-object p1
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

.method public p(I)Z
    .locals 1

    .line 1
    iget-object v0, p0, Leh/d$a;->a:Lbh/e;

    .line 2
    .line 3
    invoke-interface {v0, p1}, Lbh/e;->p(I)Z

    .line 4
    .line 5
    .line 6
    move-result p1

    .line 7
    return p1
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
