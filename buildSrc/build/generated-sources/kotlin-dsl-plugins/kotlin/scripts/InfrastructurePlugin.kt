package scripts


/**
 * Precompiled [infrastructure.gradle.kts][scripts.Infrastructure_gradle] script plugin.
 *
 * @see scripts.Infrastructure_gradle
 */
class InfrastructurePlugin : org.gradle.api.Plugin<org.gradle.api.Project> {
    override fun apply(target: org.gradle.api.Project) {
        try {
            Class
                .forName("scripts.Infrastructure_gradle")
                .getDeclaredConstructor(org.gradle.api.Project::class.java, org.gradle.api.Project::class.java)
                .newInstance(target, target)
        } catch (e: java.lang.reflect.InvocationTargetException) {
            throw e.targetException
        }
    }
}
