import { Tabs } from 'expo-router';

export default function TabsLayout() {
  return (
    <Tabs>
      <Tabs.Screen name="login" options={{ title: 'Login' }} />
      <Tabs.Screen name="signup" options={{ title: 'Signup' }} />
      <Tabs.Screen name="expense" options={{ title: 'Expenses' }} />
    </Tabs>
  );
}
