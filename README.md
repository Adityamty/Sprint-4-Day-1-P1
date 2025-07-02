# Sprint-4-Day-1-P1

# Spring Boot Greeter Project: Architecture & Auto-Configuration Report

## Project Overview

This project demonstrates **Spring Boot’s bean management and auto-configuration** by defining a simple `Greeter` service in three different ways:

- **Java config class:**  
  A `@Configuration` class with a `@Bean` method for `Greeter`.
- **Component scan:**  
  A `GreeterComponent` class annotated with `@Component`.
- **Conditional auto-configuration:**  
  A `GreeterAutoConfiguration` class with a `@Bean` method for `Greeter`, annotated with `@ConditionalOnMissingBean`.

---

## Bean Conflict Resolution

Initially, having both a `@Component` and a `@Bean` for `Greeter` caused a bean conflict—Spring found multiple candidates when injecting `Greeter`.

This was resolved by marking the `GreeterComponent` as `@Primary`, making it the default bean for injection when more than one candidate is present.

---

## Auto-Configuration Behavior

- The `GreeterAutoConfiguration` class uses `@ConditionalOnMissingBean(Greeter.class)`, so its bean is **only registered if no other `Greeter` bean exists**.
- Since `GreeterComponent` (with `@Primary`) and `greeterFromConfig` already exist, the auto-configured bean is **not created**.
- This prevents bean clashes and ensures that custom or user-defined beans always take precedence over auto-configured defaults.

---

## Auto-Configuration Report Highlights

- **Positive matches:**  
  Core Spring Boot auto-configurations loaded as expected (e.g., AOP, TaskExecution).
- **Negative matches:**  
  `GreeterAutoConfiguration#greeterAutoConfig` was skipped because Spring detected existing `Greeter` beans.
- **No runtime errors:**  
  The application started successfully, injected the `@Primary` bean, and printed the expected greeting.

---

## Conclusion

This project illustrates:

- How Spring Boot handles multiple bean definitions for the same type.
- The importance of `@Primary` and `@ConditionalOnMissingBean` in resolving bean conflicts and enabling safe auto-configuration.

