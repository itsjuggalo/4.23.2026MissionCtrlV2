.class public final Lua/c$c;
.super Ljava/lang/Object;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"

# interfaces
.implements Ly8/e;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lua/c;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "c"
.end annotation


# static fields
.field public static final a:Lua/c$c;

.field public static final b:Ly8/d;

.field public static final c:Ly8/d;

.field public static final d:Ly8/d;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .line 1
    new-instance v0, Lua/c$c;

    .line 2
    .line 3
    invoke-direct {v0}, Lua/c$c;-><init>()V

    .line 4
    .line 5
    .line 6
    sput-object v0, Lua/c$c;->a:Lua/c$c;

    .line 7
    .line 8
    const-string v0, "performance"

    .line 9
    .line 10
    invoke-static {v0}, Ly8/d;->d(Ljava/lang/String;)Ly8/d;

    .line 11
    .line 12
    .line 13
    move-result-object v0

    .line 14
    sput-object v0, Lua/c$c;->b:Ly8/d;

    .line 15
    .line 16
    const-string v0, "crashlytics"

    .line 17
    .line 18
    invoke-static {v0}, Ly8/d;->d(Ljava/lang/String;)Ly8/d;

    .line 19
    .line 20
    .line 21
    move-result-object v0

    .line 22
    sput-object v0, Lua/c$c;->c:Ly8/d;

    .line 23
    .line 24
    const-string v0, "sessionSamplingRate"

    .line 25
    .line 26
    invoke-static {v0}, Ly8/d;->d(Ljava/lang/String;)Ly8/d;

    .line 27
    .line 28
    .line 29
    move-result-object v0

    .line 30
    sput-object v0, Lua/c$c;->d:Ly8/d;

    .line 31
    .line 32
    return-void
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

.method public constructor <init>()V
    .locals 0

    .line 1
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 2
    .line 3
    .line 4
    return-void
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


# virtual methods
.method public bridge synthetic a(Ljava/lang/Object;Ljava/lang/Object;)V
    .locals 0

    .line 1
    check-cast p1, Lua/e;

    .line 2
    .line 3
    check-cast p2, Ly8/f;

    .line 4
    .line 5
    invoke-virtual {p0, p1, p2}, Lua/c$c;->b(Lua/e;Ly8/f;)V

    .line 6
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

.method public b(Lua/e;Ly8/f;)V
    .locals 3

    .line 1
    sget-object v0, Lua/c$c;->b:Ly8/d;

    .line 2
    .line 3
    invoke-virtual {p1}, Lua/e;->b()Lua/d;

    .line 4
    .line 5
    .line 6
    move-result-object v1

    .line 7
    invoke-interface {p2, v0, v1}, Ly8/f;->e(Ly8/d;Ljava/lang/Object;)Ly8/f;

    .line 8
    .line 9
    .line 10
    sget-object v0, Lua/c$c;->c:Ly8/d;

    .line 11
    .line 12
    invoke-virtual {p1}, Lua/e;->a()Lua/d;

    .line 13
    .line 14
    .line 15
    move-result-object v1

    .line 16
    invoke-interface {p2, v0, v1}, Ly8/f;->e(Ly8/d;Ljava/lang/Object;)Ly8/f;

    .line 17
    .line 18
    .line 19
    sget-object v0, Lua/c$c;->d:Ly8/d;

    .line 20
    .line 21
    invoke-virtual {p1}, Lua/e;->c()D

    .line 22
    .line 23
    .line 24
    move-result-wide v1

    .line 25
    invoke-interface {p2, v0, v1, v2}, Ly8/f;->b(Ly8/d;D)Ly8/f;

    .line 26
    .line 27
    .line 28
    return-void
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
