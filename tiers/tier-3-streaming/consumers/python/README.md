# Consumer mock (Python)

But: consommer un topic et afficher les messages.

Pré-requis:
- Python 3.10+
- `pip install confluent-kafka`

Exécution:
```bash
export KAFKA_BOOTSTRAP=localhost:9092
python consume.py grid.meter.reading.v1.dev
```
