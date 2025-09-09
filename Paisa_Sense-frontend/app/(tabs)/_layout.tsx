import { Tabs } from 'expo-router';

export default function TabsLayout() {
  return (
    <Tabs>
      <Tabs.Screen name="screens/LoginScreen" options={{ title: 'Login' }} />
      <Tabs.Screen name="screens/ExpenseScreen" options={{ title: 'Expenses' }} />
    </Tabs>
  );
}
