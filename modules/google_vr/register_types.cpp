#include <version_generated.gen.h>

#if VERSION_MAJOR == 3
#include <core/class_db.h>
#include <core/engine.h>
#else
#include "object_type_db.h"
#include "core/globals.h"
#endif

#include "register_types.h"
#include "ios/src/godotGoogleVR.h"

void register_admob_types() {
#if VERSION_MAJOR == 3
    Engine::get_singleton()->add_singleton(Engine::Singleton("GoogleVR", memnew(GodotGooglevr)));
#else
    Globals::get_singleton()->add_singleton(Globals::Singleton("GoogleVR", memnew(GodotGooglevr)));
#endif
}

void unregister_admob_types() {
}
