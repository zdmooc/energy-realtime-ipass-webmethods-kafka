import http from 'k6/http';
import { check, sleep } from 'k6';

export const options = {
  vus: 10,
  duration: '30s',
};

export default function () {
  const url = __ENV.API_URL || 'http://localhost:8080/v1/meter-readings';
  const payload = JSON.stringify({
    eventId: '00000000-0000-0000-0000-000000000001',
    eventType: 'grid.meter.reading',
    eventVersion: 'v1',
    occurredAt: new Date().toISOString(),
    sourceSystem: 'k6',
    correlationId: 'corr-k6',
    partitionKey: 'meter-1',
    payload: {
      meterId: 'meter-1',
      siteId: 'site-1',
      readingType: 'ACTIVE_POWER',
      value: Math.random() * 1000,
      unit: 'kW',
      readingAt: new Date().toISOString(),
    },
  });

  const res = http.post(url, payload, { headers: { 'Content-Type': 'application/json' }});
  check(res, { 'status is 202': (r) => r.status === 202 });
  sleep(1);
}
