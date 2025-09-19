import React from 'react';
import { View, Text, Button } from 'react-native';

export default function LoginScreen({ navigation }) {
  return (
    <View>
      <Text>Login Screen</Text>
      <Button title="Go to Signup" onPress={() => navigation.navigate('Signup')} />
      <Button title="Go to Expenses" onPress={() => navigation.navigate('Expenses')} />
    </View>
  );
}
