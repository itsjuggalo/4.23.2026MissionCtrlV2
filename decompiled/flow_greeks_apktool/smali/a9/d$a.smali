.class public La9/d$a;
.super Ljava/lang/Object;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"

# interfaces
.implements Ly8/a;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = La9/d;->i()Ly8/a;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = null
.end annotation


# instance fields
.field public final synthetic a:La9/d;


# direct methods
.method public constructor <init>(La9/d;)V
    .locals 0

    .line 1
    iput-object p1, p0, La9/d$a;->a:La9/d;

    .line 2
    .line 3
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 4
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
    .line 20
    .line 21
    .line 22
    .line 23
    .line 24
.end method


# virtual methods
.method public a(Ljava/lang/Object;Ljava/io/Writer;)V
    .locals 6

    .line 1
    new-instance v0, La9/e;

    .line 2
    .line 3
    iget-object v1, p0, La9/d$a;->a:La9/d;

    .line 4
    .line 5
    invoke-static {v1}, La9/d;->e(La9/d;)Ljava/util/Map;

    .line 6
    .line 7
    .line 8
    move-result-object v2

    .line 9
    iget-object v1, p0, La9/d$a;->a:La9/d;

    .line 10
    .line 11
    invoke-static {v1}, La9/d;->f(La9/d;)Ljava/util/Map;

    .line 12
    .line 13
    .line 14
    move-result-object v3

    .line 15
    iget-object v1, p0, La9/d$a;->a:La9/d;

    .line 16
    .line 17
    invoke-static {v1}, La9/d;->g(La9/d;)Ly8/e;

    .line 18
    .line 19
    .line 20
    move-result-object v4

    .line 21
    iget-object v1, p0, La9/d$a;->a:La9/d;

    .line 22
    .line 23
    invoke-static {v1}, La9/d;->h(La9/d;)Z

    .line 24
    .line 25
    .line 26
    move-result v5

    .line 27
    move-object v1, p2

    .line 28
    invoke-direct/range {v0 .. v5}, La9/e;-><init>(Ljava/io/Writer;Ljava/util/Map;Ljava/util/Map;Ly8/e;Z)V

    .line 29
    .line 30
    .line 31
    const/4 p2, 0x0

    .line 32
    invoke-virtual {v0, p1, p2}, La9/e;->k(Ljava/lang/Object;Z)La9/e;

    .line 33
    .line 34
    .line 35
    invoke-virtual {v0}, La9/e;->u()V

    .line 36
    .line 37
    .line 38
    return-void
    .line 39
.end method

.method public b(Ljava/lang/Object;)Ljava/lang/String;
    .locals 1

    .line 1
    new-instance v0, Ljava/io/StringWriter;

    .line 2
    .line 3
    invoke-direct {v0}, Ljava/io/StringWriter;-><init>()V

    .line 4
    .line 5
    .line 6
    :try_start_0
    invoke-virtual {p0, p1, v0}, La9/d$a;->a(Ljava/lang/Object;Ljava/io/Writer;)V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 7
    .line 8
    .line 9
    :catch_0
    invoke-virtual {v0}, Ljava/io/StringWriter;->toString()Ljava/lang/String;

    .line 10
    .line 11
    .line 12
    move-result-object p1

    .line 13
    return-object p1
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
